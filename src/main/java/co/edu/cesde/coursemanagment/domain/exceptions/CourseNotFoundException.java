package co.edu.cesde.coursemanagment.domain.exceptions;

public class CourseNotFoundException extends ResourceNotFoundException {
    public CourseNotFoundException(Long id) {
        super("Course not found: " + id);
    }
}
