package co.edu.cesde.coursemanagment.domain.exceptions;

public class StudentNotFoundException extends ResourceNotFoundException {
    public StudentNotFoundException(Long id) {
        super("Student not found: " + id);
    }
}