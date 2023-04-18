package com.georgeclam.limbo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/****************************************************************************
 * <b>Title</b>: ApiException.java
 * <b>Project</b>: Limbo Gallery - Backend
 * <b>Description: </b> Sets the fields for throwing an Exception to the Client's HTTP Requests.
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author George Clam
 * @version 1.0
 * @since Apr 17, 2023
 * @updates:
 ****************************************************************************/

@AllArgsConstructor
@Getter
@ToString
public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

}
