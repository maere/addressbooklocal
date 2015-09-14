/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.model;

import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author apprentice--DTO
 */
public class Address {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.firstName);
        hash = 83 * hash + Objects.hashCode(this.lastName);
        hash = 83 * hash + Objects.hashCode(this.street);
        hash = 83 * hash + Objects.hashCode(this.city);
        hash = 83 * hash + Objects.hashCode(this.state);
        hash = 83 * hash + this.zipCode;
        hash = 83 * hash + this.idNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (this.zipCode != other.zipCode) {
            return false;
        }
        if (this.idNumber != other.idNumber) {
            return false;
        }
        return true;
    }

    //fields -- these should all be privately scoped
    @NotEmpty(message = "You must supply a value for the first name.")
    @Length(max = 50, message = "First Name must be no more than 50 characters in length.")
    private String firstName;

    @NotEmpty(message = "You must supply a value for the last name.")
    @Length(max = 50, message = "Last Name must be no more than 50 characters in length.")
    private String lastName;

    @NotEmpty(message = "You must supply a value for the street address.")
    @Length(max = 60, message = "The street address must be no more than 60 characters in length.")
    private String street;

    @NotEmpty(message = "You must supply a value for the city.")
    @Length(max = 40, message = "City name must be no more than 40 characters in length.")
    private String city;

    @NotEmpty(message = "You must supply a value for the state.")
    @Length(max = 2, message = "State abbreviation must be no more than 2 characters in length.")
    private String state;
   
    //@NotEmpty(message = "You must supply a zip, 5 digits only.")
    @Range(min = 1, max = 99999, message="You must supply a zip, 5 digits only.") //age need between 1 and 150
    private int zipCode;     
    //private String zipCode; //future zipCodes and postalCodes will all be constructed as a string to account for dashes, CA, UK, etc.

    private int idNumber;

    //constructor
    public Address() {

    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
}//end class
