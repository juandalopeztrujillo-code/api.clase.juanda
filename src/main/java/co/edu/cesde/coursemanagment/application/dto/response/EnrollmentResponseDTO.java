package co.edu.cesde.coursemanagment.application.dto.response;

import co.edu.cesde.coursemanagment.domain.models.EnrollmentStatus;
import java.time.LocalDate;

public record EnrollmentResponseDTO(
        Long id,
        Long studentId,
        Long courseId,
        LocalDate enrollmentDate,
        EnrollmentStatus status
) {}