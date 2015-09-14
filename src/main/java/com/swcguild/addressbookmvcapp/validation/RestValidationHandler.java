/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvcapp.validation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@ControllerAdvice

public class RestValidationHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorContainer processValidationErrors(MethodArgumentNotValidException e){  //this method will process validationErrors and return a ValidationErrorContainer
        
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors(); //our getter method
        
        //now we need to make a ValidationErrorContainer to fill bc that is what we are returning from this method
        ValidationErrorContainer errors = new ValidationErrorContainer();
        
        //for each loop to add each error to the container
        for(FieldError currentError : fieldErrors){
            errors.addErrors(currentError.getField(), currentError.getDefaultMessage());
        }
        
        return errors;
    
    }                   
    
}
