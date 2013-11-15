package org.fedon.matrix.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * @author Dmytro Fedonin
 *
 */
public class MatrixAppException extends WebApplicationException {
    private static final long serialVersionUID = 1L;
    private final Response response;

    public MatrixAppException(String message, Throwable cause) {
        super(cause);
        response = Response.serverError().entity(cause).build();
    }

    public MatrixAppException(Object message) {
        response = Response.serverError().entity(message).build();
    }

    // public MatrixAppException(String message) {
    // response = Response.serverError().entity(message).build();
    // }

    public Response getResponse() {
        return response;
    }
}
