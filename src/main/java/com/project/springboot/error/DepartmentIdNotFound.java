package com.project.springboot.error;

public class DepartmentIdNotFound extends  Exception{
    public DepartmentIdNotFound() {
        super();
    }

    public DepartmentIdNotFound(String message) {
        super(message);
    }

    public DepartmentIdNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentIdNotFound(Throwable cause) {
        super(cause);
    }

    protected DepartmentIdNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
