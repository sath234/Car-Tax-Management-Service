package com.example.car_tax_management.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NumberFormatException.class})
    protected ResponseEntity<Object> numberFormateExceptionHandler(RuntimeException ex, WebRequest request){
        String bodyText = "Conversion failed - please specify a number.";
        return handleExceptionInternal(ex, bodyText,new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }
}
