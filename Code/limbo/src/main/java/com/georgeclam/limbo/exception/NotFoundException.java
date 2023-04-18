package com.georgeclam.limbo.exception;

/****************************************************************************
 * <b>Title</b>: NotFoundException.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> Provides custom HTTP Response Statuses to the client to better illustrate why a request
 * may have failed. The exception for the NotFoundException class is built in the ApiRequestHandler class.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

public class NotFoundException extends RuntimeException {

    /**
     * Constructor which assigns the message in the exception.
     *
     * @param message
     */
    public NotFoundException(String message) {
        super(message);
    }
}