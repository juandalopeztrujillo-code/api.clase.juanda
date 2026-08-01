package co.edu.cesde.coursemanagment.application.exceptions;

public class EnrollmentNotFoundException extends BusinessException {
    public EnrollmentNotFoundException(Long id) {
        super("Enrollment not found: " + id);
    }
}
