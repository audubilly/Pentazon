package com.pentazon.exceptions;

public class CheckOutException extends PentazonException{

    public CheckOutException(String message) {
        super(message);
    }

    public CheckOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckOutException(Throwable cause) {
        super(cause);
    }
}
