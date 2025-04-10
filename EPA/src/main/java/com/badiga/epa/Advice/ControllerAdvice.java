package com.badiga.epa.Advice;

import com.badiga.epa.Exceptions.CategoryAlreadyExistException;
import com.badiga.epa.Exceptions.ProductNotFoundException;
import com.badiga.epa.Exceptions.UserAlreadyExist;
import com.badiga.epa.Exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFoundException(ProductNotFoundException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(UserAlreadyExist.class)
    public String handleProductNotFoundException(UserAlreadyExist ex){
        return ex.getMessage();
    }
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException ex){
        return ex.getMessage();
    }
    @ExceptionHandler(CategoryAlreadyExistException.class)
    public String handleCategoryAlreadyExistException(CategoryAlreadyExistException ex) {
        return ex.getMessage();
    }
}
