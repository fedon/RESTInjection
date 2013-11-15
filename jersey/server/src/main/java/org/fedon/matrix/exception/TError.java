package org.fedon.matrix.exception;

/**
 * @author Dmytro Fedonin
 *
 */
public class TError {
    private String message;
    private int code;

    /**
     * @param message
     * @param code
     */
    public TError(String message, int code) {
        super();
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
