package co.edu.cesde.coursemanagment.application.service;

import co.edu.cesde.coursemanagment.application.dto.StudentDTO;
import co.edu.cesde.coursemanagment.domain.exceptions.BusinessException;
import co.edu.cesde.coursemanagment.domain.exceptions.StudentNotFoundException;
import co.edu.cesde.coursemanagment.domain.models.Student;
import co.edu.cesde.coursemanagment.domain.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentDTO create(StudentDTO dto) {
        validateStudentDTO(dto);
        if (repository.findById(dto.id()).isPresent()) {
            throw new BusinessException("Student with ID " + dto.id() + " already exists.");
        }
        Student student = new Student(dto.id(), dto.firstName(), dto.lastName(), dto.email(), dto.birthDate());
        return mapToDTO(repository.save(student));
    }

    public StudentDTO findById(Long id) {
        validateId(id);
        return repository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<StudentDTO> findAll() {
        return repository.findAll().stream().map(this::mapToDTO).toList();
    }

    public StudentDTO update(Long id, StudentDTO dto) {
        validateId(id);
        validateStudentDTO(dto);
        findById(id); // Valida si existe

        Student student = new Student(id, dto.firstName(), dto.lastName(), dto.email(), dto.birthDate());
        return mapToDTO(repository.save(student));
    }

    public void delete(Long id) {
        validateId(id);
        findById(id); // Valida si existe
        repository.deleteById(id);
    }

    // --- Validaciones ---
    private void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new BusinessException("ID must be a positive number.");
        }
    }

    private void validateStudentDTO(StudentDTO dto) {
        if (dto == null) {
            throw new BusinessException("Student data cannot be null.");
        }
        validateId(dto.id());
        if (dto.firstName() == null || dto.firstName().isBlank()) {
            throw new BusinessException("First name cannot be empty.");
        }
        if (dto.lastName() == null || dto.lastName().isBlank()) {
            throw new BusinessException("Last name cannot be empty.");
        }
        if (dto.email() == null || !dto.email().contains("@")) {
            throw new BusinessException("Invalid email format.");
        }
    }

    private StudentDTO mapToDTO(Student s) {
        return new StudentDTO(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getBirthDate());
    }
}