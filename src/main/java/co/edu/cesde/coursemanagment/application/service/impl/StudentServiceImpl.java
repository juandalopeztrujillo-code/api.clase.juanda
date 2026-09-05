package co.edu.cesde.coursemanagment.application.service.impl;

import co.edu.cesde.coursemanagment.application.dto.StudentDTO;
import co.edu.cesde.coursemanagment.application.service.StudentService;
import co.edu.cesde.coursemanagment.domain.exceptions.BusinessException;
import co.edu.cesde.coursemanagment.domain.exceptions.StudentNotFoundException;
import co.edu.cesde.coursemanagment.domain.models.Student;
import co.edu.cesde.coursemanagment.domain.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentDTO create(StudentDTO dto) {
        if (dto == null || dto.id() == null) {
            throw new BusinessException("Student data or ID cannot be null.");
        }
        if (repository.findById(dto.id()).isPresent()) {
            throw new BusinessException("Student with ID " + dto.id() + " already exists.");
        }
        Student student = new Student(dto.id(), dto.firstName(), dto.lastName(), dto.email(), dto.birthDate());
        return mapToDTO(repository.save(student));
    }

    @Override
    public StudentDTO findById(Long id) {
        if (id == null) {
            throw new BusinessException("ID cannot be null.");
        }
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public List<StudentDTO> findAll() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public StudentDTO update(Long id, StudentDTO dto) {
        if (id == null || dto == null) {
            throw new BusinessException("ID and Student data cannot be null.");
        }
        findById(id); // Valida que exista
        Student student = new Student(id, dto.firstName(), dto.lastName(), dto.email(), dto.birthDate());
        return mapToDTO(repository.save(student));
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException("ID cannot be null.");
        }
        findById(id); // Valida que exista
        repository.deleteById(id);
    }

    private StudentDTO mapToDTO(Student s) {
        return new StudentDTO(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getBirthDate());
    }
}