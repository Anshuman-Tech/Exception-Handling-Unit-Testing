package com.anshuman.unit_testing.Error;

public class DepartmentNotSaved extends Exception {
    public DepartmentNotSaved() {
        super();
    }

    public DepartmentNotSaved(String message) {
        super(message);
    }

    public DepartmentNotSaved(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotSaved(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotSaved(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
