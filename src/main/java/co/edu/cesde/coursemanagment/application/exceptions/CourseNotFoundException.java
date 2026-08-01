package co.edu.cesde.coursemanagment.application.exceptions;

public class CourseNotFoundException extends BusinessException {
    public CourseNotFoundException(Long id) {
        super("Course not found: " + id);
    }
}
