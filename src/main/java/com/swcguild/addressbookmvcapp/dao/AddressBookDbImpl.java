/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.dao;

import com.swcguild.addressbookmvcapp.model.Address;
import com.swcguild.addressbookmvcapp.model.SearchTerm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class AddressBookDbImpl implements AddressBookAPI {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //sql statements
    public static final String SQL_INSERT_ADDRESS = "INSERT INTO addresses (first_name, last_name, street, city, state, zip) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE_ADDRESS = "DELETE FROM addresses WHERE id_number=?";
    public static final String SQL_UPDATE_ADDRESS = "UPDATE addresses "
            + "SET first_name=?, last_name=?, street=?, city=?, state=?, zip=?"
            + " WHERE id_number=?";
    public static final String SQL_GET_ADDRESS = "SELECT * FROM addresses WHERE id_number = ?";
    public static final String SQL_GET_ALL_ADDRESSES = "SELECT * FROM addresses";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAddressToBook(Address addressObject) { //first thing that always happens is to call on the jdbcTemplate to help us out
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                addressObject.getFirstName(),
                addressObject.getLastName(),
                addressObject.getStreet(),
                addressObject.getCity(),
                addressObject.getState(),
                addressObject.getZipCode());
        //get the next number from the DB and call the jdbc to tack it onto the inMemory(?)Object we are passing
        addressObject.setIdNumber(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));

        //could change interface to return addressObject if desired for user feedback
    }

    @Override
    public void removeAddress(int idNumber) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, idNumber); //idNumber is from Java

    }

    @Override
    public Address getAddress(int idNumber) { //java wants me to change the return type for this method toList

        try {
            return jdbcTemplate.queryForObject(SQL_GET_ADDRESS, new AddressMapper(), idNumber);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Address> getAllAddresses() {
        return jdbcTemplate.query(SQL_GET_ALL_ADDRESSES, new AddressMapper());

    }

    @Override
    public void update(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS, 
                address.getFirstName(), 
                address.getLastName(), 
                address.getStreet(),
                address.getCity(),
                address.getState(), 
                address.getZipCode(),
                address.getIdNumber());
    }

    @Override
    public List<Address> searchAddresses(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> citySearch(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> zipSearch(int zipCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, List<Address>> stateSearch(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> nameSearch(String lastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadAddresses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeToAddresses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //addressMapper class
    private static final class AddressMapper implements ParameterizedRowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {

            //make a new Object, get the value from the result set and use this to set all the fields, and return object
            Address address = new Address();
            //include the ID
            address.setIdNumber(rs.getInt("id_number"));
            address.setFirstName(rs.getString("first_name"));
            address.setLastName(rs.getString("last_name"));
            address.setStreet(rs.getString("street"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZipCode(rs.getInt("zip")); //think I might need toString

            return address;

        }

    }

}
