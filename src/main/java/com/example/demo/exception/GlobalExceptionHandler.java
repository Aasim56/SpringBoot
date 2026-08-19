package com.example.demo.exception;

import com.example.demo.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//      STUDENT NOT FOUND EXCEPTION
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleStudentNotFound(StudentNotFoundException exception){
        return new ErrorResponseDTO(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

//      VALIDATION EXCEPTION
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleValidationException(MethodArgumentNotValidException exception){

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                         .forEach(
                                 error -> errors.put(
                                    error.getField(),
                                    error.getDefaultMessage()
                        ));

        return new ErrorResponseDTO(
                400,
                "validation Error",
                LocalDateTime.now(),
                errors
        );
    }


}
