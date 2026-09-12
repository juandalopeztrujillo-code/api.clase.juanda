package co.edu.cesde.coursemanagment.domain.exceptions;

public class EnrollmentNotFoundException extends ResourceNotFoundException {
    public EnrollmentNotFoundException(Long id) {
        super("Enrollment not found: " + id);
    }
}

