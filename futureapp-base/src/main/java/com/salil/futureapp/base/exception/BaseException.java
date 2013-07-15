package com.salil.futureapp.base.exception;

/**
 * @author salil
 * @version 1.0
 */
public class BaseException extends Exception {
    /**
     * Serial Version Id.
     */
    private static final long serialVersionUID = -3483027268426131876L;

    /**
     * Creates a new BaseException object.
     * 
     * @param message
     *            - error message to be shown.
     * @param cause
     *            - cause of the error.
     */
    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new BaseException object.
     * 
     * @param message
     *            - error message to be shown.
     */
    public BaseException(final String message) {
        super(message);
    }
}
