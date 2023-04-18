package com.georgeclam.limbo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}


//.orElseThrow(() -> new NotFoundException(
//        "The Customer with ID " + id + " was not found"
//        ));