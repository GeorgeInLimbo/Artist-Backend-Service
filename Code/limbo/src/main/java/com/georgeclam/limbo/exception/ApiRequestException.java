package com.georgeclam.limbo.exception;

/****************************************************************************
 * <b>Title</b>: ApiRequestException.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> This class extends Java's RuntimeException class assists in building an exception with
 * an optional parameter of a Throwable.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

public class ApiRequestException extends RuntimeException {

    /**
     * Constructor that builds an exception with just a message.
     *
     * @param message
     */
    public ApiRequestException(String message) {
        super(message);
    }

    /**
     * Constructor that builds an exception with both a message and a Throwable.
     *
     * @param message
     * @param cause
     */
    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
