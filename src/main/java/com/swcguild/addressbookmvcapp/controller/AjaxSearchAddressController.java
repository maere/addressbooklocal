/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.controller;

import com.swcguild.addressbookmvcapp.dao.AddressBookAPI;
import com.swcguild.addressbookmvcapp.model.Address;
import com.swcguild.addressbookmvcapp.model.SearchTerm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
//don't forget to annotate this as a controller
@Controller
public class AjaxSearchAddressController {
    
    //declare a dao
    private AddressBookAPI dao;
    
    //inject and instantiate a dao in the contsructor
    @Inject
    public AjaxSearchAddressController(AddressBookAPI dao){
        this.dao = dao;
    
    }
    
    //write a get method for the search
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String getSearch(){
        return "search";
    }
    
    //new  ENUM is  FIRST_NAME, LAST_NAME, STREET, CITY, STATE, ZIP_CODE
    //write a POST method for the search
    @RequestMapping(value="/search/addresses", method=RequestMethod.POST) //we would we want a separate route vs. the same route with a diff reqMethod
    @ResponseBody public List<Address> searchResults(@RequestBody Map<String, String> criteriaMap){
        
        //we need to build a hash for the Search method we wrote in the DAO with the enum values as keys
        Map<SearchTerm, String> searchMap = new HashMap<>();
        
        String currentTerm = criteriaMap.get("firstName"); //we need to pass in a string, coming out of the request body, which should MATCH the java DTO
        if(!currentTerm.isEmpty()){ // a string is never null 
            //put this term to the new map we made
            searchMap.put(SearchTerm.FIRST_NAME, currentTerm);
        }
        
        currentTerm = criteriaMap.get("lastName");
        if(!currentTerm.isEmpty()){
            searchMap.put(SearchTerm.LAST_NAME, currentTerm);
        }
        
        currentTerm = criteriaMap.get("street");
        if(!currentTerm.isEmpty()){
            searchMap.put(SearchTerm.STREET, currentTerm);
        }
        
        currentTerm = criteriaMap.get("city");
        if(!currentTerm.isEmpty()){
            searchMap.put(SearchTerm.CITY, currentTerm);
        }
        
        currentTerm = criteriaMap.get("state");
        if(!currentTerm.isEmpty()){
            searchMap.put(SearchTerm.STATE, currentTerm);
        }
        
        currentTerm = criteriaMap.get("zipCode");
        if(!currentTerm.isEmpty()){
            searchMap.put(SearchTerm.ZIP_CODE, currentTerm);
        }
        
        //then call the dao search method and pass the map we jsut contstructed
        return dao.searchAddresses(searchMap);
    
    }
    
}
