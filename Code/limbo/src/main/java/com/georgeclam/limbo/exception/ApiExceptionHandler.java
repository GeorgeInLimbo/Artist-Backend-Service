package com.georgeclam.limbo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

/****************************************************************************
 * <b>Title</b>: ApiExceptionHandler.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> Builds the exception for the NotFoundException class.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

@ControllerAdvice
public class ApiExceptionHandler {

//    @ExceptionHandler(value = ApiRequestException.class)
//    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
//        ApiException apiException = new ApiException(
//                e.getMessage(),
//                e,
//                HttpStatus.BAD_REQUEST,
//                ZonedDateTime.now()
//        );
//        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
//    }

    /**
     * Builds the values to be used in a NotFoundException
     * Status Code of 404 to indicate a Client-side Error
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(NotFoundException e) {
        ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
