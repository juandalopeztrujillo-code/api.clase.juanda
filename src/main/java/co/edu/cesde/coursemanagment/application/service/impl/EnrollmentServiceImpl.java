package co.edu.cesde.coursemanagment.application.service.impl;

import co.edu.cesde.coursemanagment.application.dto.EnrollmentDTO;
import co.edu.cesde.coursemanagment.application.service.CourseService;
import co.edu.cesde.coursemanagment.application.service.EnrollmentService;
import co.edu.cesde.coursemanagment.application.service.StudentService;
import co.edu.cesde.coursemanagment.domain.exceptions.BusinessException;
import co.edu.cesde.coursemanagment.domain.exceptions.EnrollmentNotFoundException;
import co.edu.cesde.coursemanagment.domain.models.Enrollment;
import co.edu.cesde.coursemanagment.domain.models.EnrollmentStatus;
import co.edu.cesde.coursemanagment.domain.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, StudentService studentService, CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public EnrollmentDTO create(Long id, Long studentId, Long courseId) {
        if (id == null || studentId == null || courseId == null) {
            throw new BusinessException("Los IDs no pueden ser nulos.");
        }
        if (enrollmentRepository.findById(id).isPresent()) {
            throw new BusinessException("La matrícula con ID " + id + " ya existe.");
        }

        studentService.findById(studentId); // Valida existencia del estudiante
        courseService.findById(courseId);   // Valida existencia del curso

        Enrollment enrollment = new Enrollment(id, studentId, courseId, LocalDate.now(), EnrollmentStatus.ACTIVE);
        return mapToDTO(enrollmentRepository.save(enrollment));
    }

    @Override
    public EnrollmentDTO findById(Long id) {
        if (id == null) {
            throw new BusinessException("El ID no puede ser nulo.");
        }
        return enrollmentRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
    }

    @Override
    public List<EnrollmentDTO> findAll() {
        return enrollmentRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public EnrollmentDTO cancelEnrollment(Long id) {
        if (id == null) {
            throw new BusinessException("El ID no puede ser nulo.");
        }
        EnrollmentDTO dto = findById(id); // Valida existencia
        Enrollment updated = new Enrollment(dto.id(), dto.studentId(), dto.courseId(), dto.enrollmentDate(), EnrollmentStatus.CANCELLED);
        return mapToDTO(enrollmentRepository.save(updated));
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException("El ID no puede ser nulo.");
        }
        findById(id); // Valida existencia
        enrollmentRepository.deleteById(id);
    }

    private EnrollmentDTO mapToDTO(Enrollment e) {
        return new EnrollmentDTO(e.getId(), e.getStudentId(), e.getCourseId(), e.getEnrollmentDate(), e.getStatus());
    }
}