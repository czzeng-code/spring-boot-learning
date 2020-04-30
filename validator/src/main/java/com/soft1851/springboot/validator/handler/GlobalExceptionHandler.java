package com.soft1851.springboot.validator.handler;

import com.soft1851.springboot.validator.controller.PersonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zeng
 * @ClassName GlobalExceptionHandler
 * @Description TOOD
 * @Date 2020/4/30
 * @Version 1.0
 **/
@ControllerAdvice(assignableTypes = {PersonController.class})
public class GlobalExceptionHandler {

    public ResponseEntity<Map<String, String>> handlerValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fileName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fileName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
