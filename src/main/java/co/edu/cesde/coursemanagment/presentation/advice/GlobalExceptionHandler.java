package co.edu.cesde.coursemanagment.presentation.advice;

import co.edu.cesde.coursemanagment.domain.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException exception) {
        return exception.getMessage();
    }
}

