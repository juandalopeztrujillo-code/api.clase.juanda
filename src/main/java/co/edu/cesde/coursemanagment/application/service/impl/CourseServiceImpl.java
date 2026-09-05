package co.edu.cesde.coursemanagment.application.service.impl;

import co.edu.cesde.coursemanagment.application.dto.CourseDTO;
import co.edu.cesde.coursemanagment.application.service.CourseService;
import co.edu.cesde.coursemanagment.domain.exceptions.BusinessException;
import co.edu.cesde.coursemanagment.domain.exceptions.CourseNotFoundException;
import co.edu.cesde.coursemanagment.domain.models.Course;
import co.edu.cesde.coursemanagment.domain.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseDTO create(CourseDTO dto) {
        if (dto == null || dto.id() == null) {
            throw new BusinessException("El DTO del curso o su ID no pueden ser nulos.");
        }
        if (repository.findById(dto.id()).isPresent()) {
            throw new BusinessException("El curso con ID " + dto.id() + " ya existe.");
        }
        Course course = new Course(dto.id(), dto.code(), dto.name(), dto.description(), dto.maxCapacity());
        return mapToDTO(repository.save(course));
    }

    @Override
    public CourseDTO findById(Long id) {
        if (id == null) {
            throw new BusinessException("El ID no puede ser nulo.");
        }
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @Override
    public List<CourseDTO> findAll() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public CourseDTO update(Long id, CourseDTO dto) {
        if (id == null || dto == null) {
            throw new BusinessException("El ID y los datos del curso no pueden ser nulos.");
        }
        findById(id); // Valida existencia
        Course course = new Course(id, dto.code(), dto.name(), dto.description(), dto.maxCapacity());
        return mapToDTO(repository.save(course));
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException("El ID no puede ser nulo.");
        }
        findById(id); // Valida existencia
        repository.deleteById(id);
    }

    private CourseDTO mapToDTO(Course c) {
        return new CourseDTO(c.getId(), c.getCode(), c.getName(), c.getDescription(), c.getMaxCapacity());
    }
}
