package co.edu.cesde.coursemanagment.application.service;



import co.edu.cesde.coursemanagment.application.dto.CourseDTO;
import co.edu.cesde.coursemanagment.domain.exceptions.CourseNotFoundException;
import co.edu.cesde.coursemanagment.domain.models.Course;
import co.edu.cesde.coursemanagment.domain.repository.CourseRepository;

import java.util.List;

public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseDTO create(CourseDTO dto) {
        Course course = new Course(dto.id(), dto.code(), dto.name(), dto.description(), dto.maxCapacity());
        return mapToDTO(repository.save(course));
    }

    public CourseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    public List<CourseDTO> findAll() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    public CourseDTO update(Long id, CourseDTO dto) {
        findById(id);
        Course course = new Course(id, dto.code(), dto.name(), dto.description(), dto.maxCapacity());
        return mapToDTO(repository.save(course));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private CourseDTO mapToDTO(Course c) {
        return new CourseDTO(c.getId(), c.getCode(), c.getName(), c.getDescription(), c.getMaxCapacity());
    }
}
