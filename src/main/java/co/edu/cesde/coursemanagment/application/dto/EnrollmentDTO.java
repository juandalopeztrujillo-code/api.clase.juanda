package co.edu.cesde.coursemanagment.application.dto;

import co.edu.cesde.coursemanagment.domain.models.EnrollmentStatus;
import java.time.LocalDate;

public record EnrollmentDTO(Long id, Long studentId, Long courseId, LocalDate enrollmentDate, EnrollmentStatus status) {}
