package com.badiga.epa.Advice;

import com.badiga.epa.Exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFoundException(ProductNotFoundException ex) {
        return ex.getMessage();
    }
}
