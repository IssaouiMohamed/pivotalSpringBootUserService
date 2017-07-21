package com.imk.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.imk.demo.exception.BuildException;


/**
 * 
 * @author issaoumo
 * 
 * Global Level using -  @ControllerAdvice
 * Called when rest web service catch NumberFormatException 
 */


@ControllerAdvice
public class RestfulResponseExceptionHandler {

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<BuildException> numberFormatExceptionExceptionHandler(Exception ex)  {
        String cause = "PLEASE ENTER A NUMBER !";
        BuildException exModel = new BuildException(HttpStatus.BAD_REQUEST, cause,ex.getMessage());
        return new ResponseEntity<BuildException>(exModel, HttpStatus.BAD_REQUEST);

    }
    
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<BuildException> nullPointerExceptionHandler(Exception ex)  {
        String cause = "THE OBJECT IS NULL !";
        BuildException exModel = new BuildException(HttpStatus.BAD_REQUEST, cause,ex.getMessage());
        return new ResponseEntity<BuildException>(exModel, HttpStatus.BAD_REQUEST);

    }
    
   
    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<BuildException> generalExceptionHandler(Exception ex)  {
        String cause = "GENERAL EXCEPTION !";
        BuildException exModel = new BuildException(HttpStatus.BAD_REQUEST, cause,ex.getMessage());
        return new ResponseEntity<BuildException>(exModel, HttpStatus.BAD_REQUEST);

    }

}
