package co.edu.cesde.coursemanagment.domain.exceptions;

public class EnrollmentNotFoundException extends BusinessException {
    public EnrollmentNotFoundException(Long id) {
        super("Enrollment not found: " + id);
    }
}

