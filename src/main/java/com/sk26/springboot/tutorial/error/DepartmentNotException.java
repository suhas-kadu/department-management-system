package com.sk26.springboot.tutorial.error;

import com.sk26.springboot.tutorial.entity.Department;

public class DepartmentNotException extends Exception {
    public DepartmentNotException() {
        super();
    }

    public DepartmentNotException(String message) {
        super(message);
    }

    public DepartmentNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
