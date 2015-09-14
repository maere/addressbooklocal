/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp;

import com.swcguild.addressbookmvcapp.dao.AddressBookAPI;
import com.swcguild.addressbookmvcapp.model.Address;
import com.swcguild.addressbookmvcapp.model.SearchTerm;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class addressBookTests {

    AddressBookAPI dao;

    public addressBookTests() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        dao = ctx.getBean("addressBookAPI", AddressBookAPI.class);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addGetDelete() {

        Address p1 = new Address();

        p1.setFirstName("Abe");
        p1.setLastName("Ableton");
        p1.setStreet("123 Aspen");
        p1.setCity("Akron");
        p1.setState("OH");
        p1.setZipCode(44332);

        dao.addAddressToBook(p1);
        Assert.assertEquals("Abe", p1.getFirstName());

        Address testAddress = dao.getAddress(p1.getIdNumber());

        int testId = testAddress.getIdNumber();
        dao.removeAddress(testId);
        boolean listStatus = dao.getAllAddresses().isEmpty();
        Assert.assertTrue(listStatus);
    }

//    @Test
//    public void addUpdate(){
//    
//    }
    @Test
    public void listAll() {

        Address p1 = new Address();

        p1.setFirstName("Abe");
        p1.setLastName("Ableton");
        p1.setStreet("123 Aspen");
        p1.setCity("Akron");
        p1.setState("OH");
        p1.setZipCode(44332);

        dao.addAddressToBook(p1);

        Address p2 = new Address();

        p1.setFirstName("Bob");
        p1.setLastName("Boyd");
        p1.setStreet("123 Elm St");
        p1.setCity("Berkeley");
        p1.setState("CA");
        p1.setZipCode(94702);

        dao.addAddressToBook(p2);

        Address p3 = new Address();

        p1.setFirstName("Cat");
        p1.setLastName("Carr");
        p1.setStreet("123 Carter");
        p1.setCity("Lakewood");
        p1.setState("OH");
        p1.setZipCode(44112);

        dao.addAddressToBook(p3);

        List<Address> testList = dao.getAllAddresses();
        Assert.assertEquals(3, testList.size());

    }

    @Test
    public void searchByState() {

        Address p1 = new Address();

        p1.setFirstName("Abe");
        p1.setLastName("Ableton");
        p1.setStreet("123 Aspen");
        p1.setCity("Akron");
        p1.setState("OH");
        p1.setZipCode(44332);

        dao.addAddressToBook(p1);

        Address p2 = new Address();

        p1.setFirstName("Bob");
        p1.setLastName("Boyd");
        p1.setStreet("123 Baby St");
        p1.setCity("Berkeley");
        p1.setState("CA");
        p1.setZipCode(94702);

        dao.addAddressToBook(p2);

        Address p3 = new Address();

        p1.setFirstName("Cat");
        p1.setLastName("Carr");
        p1.setStreet("123 Carter");
        p1.setCity("Lakewood");
        p1.setState("OH");
        p1.setZipCode(44112);

        dao.addAddressToBook(p3);
        
        Map<SearchTerm, String> testSearchMap = new HashMap<>();
        testSearchMap.put(SearchTerm.STATE, "oh");
        
        List<Address> searchResultsAsList = dao.searchAddresses(testSearchMap);
        Assert.assertEquals(2, searchResultsAsList.size());

    }

}
