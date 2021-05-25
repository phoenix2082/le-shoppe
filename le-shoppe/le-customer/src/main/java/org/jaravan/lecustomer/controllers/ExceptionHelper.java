package org.jaravan.lecustomer.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {

    /**
     * Logger.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ExceptionHelper.class);

    /**
     * ConstraintViolationException is thrown when request do not
     * required or valid parameter.
     *
     * @param ex ConstraintViolationException
     * @return Response with failure message.
     */
    @ExceptionHandler(value = {ConstraintViolationException.class })
    public ResponseEntity<Object> handleInvalidInputException(
            final ConstraintViolationException ex) {
        LOGGER.error("Invalid Input Exception: ", ex.getMessage());
        List<String> results = new ArrayList<String>();
        ex.getConstraintViolations().forEach(cv -> {
            results.add(cv.getPropertyPath() + " " + cv.getMessage());
        });
        return new ResponseEntity<Object>(results, HttpStatus.BAD_REQUEST);

    }
}
