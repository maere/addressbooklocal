/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.validation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ValidationErrorContainer {
    
    List<ValidationError> errors = new ArrayList<>();
    
    public void addErrors(String fieldName, String message){
        
        ValidationError error = new ValidationError(fieldName, message);
        errors.add(error);
        
    }
        //custom getter
    public List<ValidationError> getFieldErrors(){
        return errors;
    }
    
    
    
}
