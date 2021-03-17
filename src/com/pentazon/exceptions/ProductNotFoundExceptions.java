package com.pentazon.exceptions;

public class ProductNotFoundExceptions extends PentazonException{


    public ProductNotFoundExceptions(String message) {
        super(message);
    }

    public ProductNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundExceptions(Throwable cause) {
        super(cause);
    }

}
