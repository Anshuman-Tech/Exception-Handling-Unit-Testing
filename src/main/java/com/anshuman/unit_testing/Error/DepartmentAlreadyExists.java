package com.anshuman.unit_testing.Error;

public class DepartmentAlreadyExists extends Exception {

    public DepartmentAlreadyExists() {
        super();
    }

    public DepartmentAlreadyExists(String message) {
        super(message);
    }

    public DepartmentAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected DepartmentAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
