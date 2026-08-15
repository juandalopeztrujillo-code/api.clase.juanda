package co.edu.cesde.coursemanagment.infrastructure.persistence;

import co.edu.cesde.coursemanagment.domain.models.Course;
import co.edu.cesde.coursemanagment.domain.repository.CourseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryCourseRepository implements CourseRepository {
    private final Map<Long, Course> storage = new HashMap<>();

    @Override
    public Course save(Course course) {
        storage.put(course.getId(), course);
        return course;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }
}

