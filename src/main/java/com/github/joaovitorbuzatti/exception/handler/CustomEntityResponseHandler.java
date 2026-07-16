package com.github.joaovitorbuzatti.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.joaovitorbuzatti.exception.ExeptionResponse;
import com.github.joaovitorbuzatti.exception.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExeptionResponse> handleAllExceptions(Exception ex, WebRequest request){

        ExeptionResponse response =  new ExeptionResponse(

            new Date(),
            ex.getMessage(),
            request.getDescription(false));

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


@ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExeptionResponse> handleBadRequestsExceptions(Exception ex, WebRequest request){

        ExeptionResponse response =  new ExeptionResponse(

            new Date(),
            ex.getMessage(),
            request.getDescription(false));

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
