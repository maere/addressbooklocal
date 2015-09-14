/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.controller;

import com.swcguild.addressbookmvcapp.dao.AddressBookImpl;
import com.swcguild.addressbookmvcapp.model.Address;
import com.swcguild.addressbookmvcapp.services.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    private ConsoleIO con = new ConsoleIO();
    private AddressBookImpl myAddressBook = new AddressBookImpl();

    //constructor -- default
    //methods
//    public void run() throws IOException, Exception {
//        boolean keepGoing = true;
//        int choice = 0;
//
//        try {
//            myAddressBook.loadAddresses(); //single source of truth, so we need to find out where it's at when we begin
//        } catch (FileNotFoundException e) {
//            System.out.println("This book has not yet been created. Would you like to create a book?");
//            //change to ConsoleIO y/n and create addresses.txt file...
//        }
//
//        while (keepGoing) {
//            mainMenu();
//
//            choice = con.readInt("Which would you like to do?");
//
//            switch (choice) {
//                case 1:
//                    createAddress();
//                    break;
//                case 2:
//                    removeAddress();
//                    break;
//                case 3:
//                    searchAddresses();
//                    break;
//                case 4:
//                    countAddresses();
//                    break;
//                case 5:
//                    listAddresses();
//                    break;
//
//                case 6:
//                    System.out.println("Exiting the system");
//                    keepGoing = false;
//                    break;
//                default:
//                    con.print("That is an invalid entry.");//this was a bad idea: assertion error or even throw new Exception() would be better....
//            }
//        //    myAddressBook.writeToAddresses();
//
//        }
//        con.print("Thanks for using this app!");
//
//        //try catch loop
//    }

    private void mainMenu() {
        con.print("Main Menu");
        con.print("---------");
        con.print("1. Add Address");
        con.print("2. Delete Address");
        con.print("3. Search Addresses");
        con.print("4. Count Addresses in Book");
        con.print("5. List All Addresses");
        con.print("6. Exit");

    }

//    public void createAddress() throws IOException {
//
//        String firstName = con.readString("Please type in the first name of the person you want to add.");
//        String lastName = con.readString("Please type in the last name of the person you want to add.");
//        String street = con.readString("Please type in their street address (e.g. 123 Elm St.)");
//        String city = con.readString("Please type in the city.");
//        String state = con.readString("Please enter the state.");
//        int zipCode = con.readInt("Please enter the zip code.");
//       //String zipCode = con.readString("Please enter the zip code.");
//
//        //create an address object
//        Address currentAddress = new Address(); //here's our abstraction of the instantiation on the fly
//
//        //currentAddress.setIdNumber(); -- moved to DAO
//        currentAddress.setFirstName(firstName);
//        currentAddress.setLastName(lastName);
//        currentAddress.setStreet(street);
//        currentAddress.setCity(city);
//        currentAddress.setState(state);
//        currentAddress.setZipCode(zipCode);
//        //currentAddress.setZipCode(zipCode);
//
//        //enter info into hashmap
//        myAddressBook.addAddressToBook(currentAddress); //in this method we ask the roster object/class
//
//        con.readString("Address successfully created. Please hit enter to continue.");
//
//    }
//
//    public void removeAddress() throws FileNotFoundException {
//        Address requestedId = null;
//        int idNumber = con.readInt("Please enter the ID of the person you would like to remove.");
////NOTE: this method needs to catch exceptions -- because it throws a Null pointer exception if you enter an ID (et al) and it cannot find that item.
//
//        try {
//
//            //if you're using a reference via a method chain as below, just do it once, and store it as a variable, otherwise you're querying the database multiple times needlessly
//            requestedId = myAddressBook.getAddress(idNumber);
//
//        } catch (FileNotFoundException e) {
//    
//            System.out.println("The addresss book was not found.");
//
//        }
//        
//        if(requestedId==null){
//           System.out.println("An address with that ID was not found.  Go back to main menu to display, or search by another method.");
//           return;  //for a method, if return type is void, you can exit a method from anywhere, with "return"
//        }
//       
//        int response = con.readInt("Are you sure you want to remove " + requestedId.getFirstName() + " " + requestedId.getLastName() + "? \n"
//                + "Enter 1 for yes, 2 for No.");                        //later: use the method chaining above to pass these values in to allow user to remove an address by lastname or another getter/setteer parameter
//        if (response == 1) {
//            myAddressBook.removeAddress(requestedId.getIdNumber());
//            con.print("Address successfully removed.");
//        } else {
//            System.out.println("Okay, fine then.");
//        }
//        
//        
//        
//
//    } //FIX try catch and File IO/FileNot found stuff

    public void searchMenu() {
        con.print("Search Menu");
        con.print("---------");
        con.print("1. Search By Last Name");
        con.print("2. Search By City");
        con.print("3. Search By State");
        con.print("4. Search By Zip");
        con.print("5. Exit Search");
    }

    public void searchAddresses() {
        searchMenu();

        int searchChoice = con.readInt("Which method would you like to search by?");

        switch (searchChoice) {
            case 1:
                searchByName();
                break;
            case 2:
                searchByCity();
                break;
            case 3:
                searchByState();
                break;
            case 4:
                searchByZip();
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
            //assertion error or throw exception

        }
    }

    private void searchByName() {
        String name = con.readString("Please enter the last name of the person you would like to find");

        List<Address> currentBook = myAddressBook.nameSearch(name);

        //boolean foundAddress = false;

        if (!currentBook.isEmpty()) {
            //foundAddress = true;
            displayFormatter(currentBook);
        } else {
            con.print("No such address found with that ID.");
        }

        con.print("Please hit enter to continue.");
    } //end method

    private void countAddresses() {

        //int total = 0;
        ArrayList<Address> a = myAddressBook.getAllAddresses();
        int totalAddresses = a.size();
        System.out.println("There are " + totalAddresses + " addresses in your address book.");

    }

    public void listAddresses() {
        ArrayList<Address> addressesAll = myAddressBook.getAllAddresses();
        for (int i = 0; i < addressesAll.size(); i++) {
            Address currentAddress = addressesAll.get(i); //do we need to do this ilya's magic way?
            System.out.println(currentAddress.getIdNumber() + "|" + currentAddress.getFirstName() + " " + currentAddress.getLastName() + "\n"
                    + currentAddress.getStreet() + "\n"
                    + currentAddress.getCity() + " " + currentAddress.getState() + " " + currentAddress.getZipCode() + "\n");
        }

    }

    private void searchByCity() {
        String city = con.readString("Enter the city: ");

        //call lambda in DAO to get all addresses by city   
        List<Address> allInCity = myAddressBook.citySearch(city);

        //swap with displayFormatter method on resulting list
        displayFormatter(allInCity);
    }

    private void searchByState() {
        String state = con.readString("Enter the state. This will return a list of addresses by city: ");

        Map<String, List<Address>> citiesInState = myAddressBook.stateSearch(state);

        //we will not want a master list here, but the sublists by city, and then will need to loop through those in the controller
        System.out.println("Address for the state of " + state + " include: \n");

        for (String cityName : citiesInState.keySet())//can use keySet because the method above returned a hashmap or hashset  
        {
            con.print("Addresses in " +cityName + ": " );
            System.out.println("-----------------------");
            displayFormatter(citiesInState.get(cityName));
            System.out.println("");

        }

    }

    private void searchByZip() {
        int zip = con.readInt("Enter the zip code you would like to search: "); //will eventually need to pass into DAOImpl function call (refactor)
        //String zip = con.readString("Placeholder for change from int to string");
        
        //lambda to get all addresses by city
        List<Address> allInZip = myAddressBook.zipSearch(zip);

        //add boolean or try/catch for zip not found  
        displayFormatter(allInZip);
    }

    public void displayFormatter(List<Address> allXinList) {
        for (Address a : allXinList) {
            System.out.println("\n" + Integer.toString(a.getIdNumber()) + "|" + a.getFirstName() + " " + a.getLastName() + "\n"
                    + a.getStreet() + "\n"
                    + a.getCity() + " " + a.getState() + " " + a.getZipCode());//Integer.toString(a.getZipCode()));
        }

    }//end formatter

}//end class

/* OLD FIND adddress by LastName

 private void findAddressByLastName() {
 String name = con.readString("Please enter the last name of the person you would like to find");

 ArrayList<Address> currentBook = myAddressBook.getAllAddresses();

 boolean foundAddress = false;

 for (Address currentAddress : currentBook) {
 if (currentAddress.getLastName().equals(name)) {
 foundAddress = true;

 System.out.println("\n" + Integer.toString(currentAddress.getIdNumber()) + "|" + currentAddress.getFirstName() + " " + currentAddress.getLastName() + "\n"
 + currentAddress.getStreet() + "\n"
 + currentAddress.getCity() + " " + currentAddress.getState() + " " + Integer.toString(currentAddress.getZipCode()));

 }//end if

 }//end for loop

 if (foundAddress == false) {
 con.print("No such address found with that ID.");
 }
 con.print("Please hit enter to continue.");
 } //end method
 */
