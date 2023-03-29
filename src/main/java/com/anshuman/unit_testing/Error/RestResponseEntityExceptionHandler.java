package com.anshuman.unit_testing.Error;

import com.anshuman.unit_testing.DTO.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ExceptionResponse> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){
        ExceptionResponse response = ExceptionResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


    /*
    @ResponseStatus can be used with class or method. It is used with exception class.
     */
    @ExceptionHandler(DepartmentAlreadyExists.class)
//    @ResponseStatus(value = HttpStatus.FOUND, reason = "Department already exists")
    public ResponseEntity<ExceptionResponse> departmentAlreadyExists(DepartmentAlreadyExists exception){
        ExceptionResponse response = ExceptionResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

}
