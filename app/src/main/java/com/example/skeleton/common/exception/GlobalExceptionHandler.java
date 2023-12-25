package com.example.skeleton.example.api.exception;

import com.example.skeleton.api.model.Error;
import com.example.skeleton.example.domain.exception.ExampleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExampleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Error handleEntityNotFoundException(ExampleNotFoundException e){
        return new Error()
                .code("EX.404")
                .message(String.format("Example with id %s not found", e.getExampleId()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Error handleInvalidArgumentException(MethodArgumentTypeMismatchException e){
        String parameterName = e.getName();
        String expectedType = e.getRequiredType().getSimpleName();

        return new Error()
                .code("EX.400")
                .message(String.format("%s should be of type %s", parameterName, expectedType));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Error handleExceptionDefault(){
        return new Error()
                .code("EX.500")
                .message("A server error has occurred. Please try again");
    }
}
