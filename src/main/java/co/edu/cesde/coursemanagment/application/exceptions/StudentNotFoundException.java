package co.edu.cesde.coursemanagment.application.exceptions;

public class StudentNotFoundException extends BusinessException {
    public StudentNotFoundException(Long id) {
        super("Student not found: " + id);
    }
}