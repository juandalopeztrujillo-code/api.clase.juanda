package co.edu.cesde.coursemanagment.application.service;



import co.edu.cesde.coursemanagment.application.dto.EnrollmentDTO;
import co.edu.cesde.coursemanagment.domain.exceptions.EnrollmentNotFoundException;
import co.edu.cesde.coursemanagment.domain.models.Enrollment;
import co.edu.cesde.coursemanagment.domain.models.EnrollmentStatus;
import co.edu.cesde.coursemanagment.domain.repository.EnrollmentRepository;

import java.time.LocalDate;
import java.util.List;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentService studentService, CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public EnrollmentDTO create(Long id, Long studentId, Long courseId) {
        studentService.findById(studentId); // Valida existencia
        courseService.findById(courseId);   // Valida existencia

        Enrollment enrollment = new Enrollment(id, studentId, courseId, LocalDate.now(), EnrollmentStatus.ACTIVE);
        return mapToDTO(enrollmentRepository.save(enrollment));
    }

    public EnrollmentDTO findById(Long id) {
        return enrollmentRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
    }

    public List<EnrollmentDTO> findAll() {
        return enrollmentRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    public EnrollmentDTO cancelEnrollment(Long id) {
        EnrollmentDTO dto = findById(id);
        Enrollment updated = new Enrollment(dto.id(), dto.studentId(), dto.courseId(), dto.enrollmentDate(), EnrollmentStatus.CANCELLED);
        return mapToDTO(enrollmentRepository.save(updated));
    }

    public void delete(Long id) {
        findById(id);
        enrollmentRepository.deleteById(id);
    }

    private EnrollmentDTO mapToDTO(Enrollment e) {
        return new EnrollmentDTO(e.getId(), e.getStudentId(), e.getCourseId(), e.getEnrollmentDate(), e.getStatus());
    }
}