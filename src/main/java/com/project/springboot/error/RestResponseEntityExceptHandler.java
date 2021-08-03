package com.project.springboot.error;

import com.project.springboot.entity.DepartmentError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(DepartmentIdNotFound.class)
    public ResponseEntity<DepartmentError> departmentNotFoundException(DepartmentIdNotFound exception , WebRequest webRequest){
        DepartmentError error = new DepartmentError(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
