package co.edu.cesde.coursemanagment.domain.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
