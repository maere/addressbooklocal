/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.controller;

import com.swcguild.addressbookmvcapp.dao.AddressBookAPI;
import com.swcguild.addressbookmvcapp.model.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value="/")
public class AjaxAddressBookController {
    
    private AddressBookAPI dao;
    
    @Inject
    public AjaxAddressBookController(AddressBookAPI dao){
        this.dao = dao;
    }
    
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
    public String displayAjaxHomePage(){
        
        return "home";
    }
    
    //CRUD REST route mapping
    //Retrieve one
    @RequestMapping(value = "/address/{idNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Address getAddress(@PathVariable("idNumber") int idNumber) throws FileNotFoundException { 
        return dao.getAddress(idNumber);
    }
//
//    //Create one
   @RequestMapping(value="/address", method=RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody                                        //replace with @Valid
   public Address createAddress(@Valid @RequestBody Address address) throws IOException{
       //is this were I parse the zip and the id?
       
       dao.addAddressToBook(address);
       return address;
   }

   //Delete one
    @RequestMapping(value = "address/{idNumber}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteAddress(@PathVariable("idNumber") int idNumber) throws FileNotFoundException { //this parse is handled for me
        dao.removeAddress(idNumber);

    }
//
//    //Update one
    @RequestMapping(value = "/address/{idNumber}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putEditedAddressToBook(@PathVariable("idNumber") int idNumber, @RequestBody Address address) {
        //think I might need to parse here as well
       address.setIdNumber(idNumber);
       
        dao.update(address);
    }
//
//    //Retrieve all
    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> listAddresses() {
        List<Address> currentAddressList = dao.getAllAddresses();
        return currentAddressList;
    }
//
//    //route to get to the search function
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchResults() {
        return "search";
    }

    //post method for our search function
    
    
    
    
}
