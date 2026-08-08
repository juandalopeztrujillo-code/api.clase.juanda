package co.edu.cesde.coursemanagment.domain.repository;


import co.edu.cesde.coursemanagment.domain.models.Course;
import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    Course save(Course course);
    Optional<Course> findById(Long id);
    List<Course> findAll();
    void deleteById(Long id);
}
