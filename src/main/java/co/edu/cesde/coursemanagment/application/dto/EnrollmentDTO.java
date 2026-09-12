package co.edu.cesde.coursemanagment.application.dto;

import co.edu.cesde.coursemanagment.domain.models.EnrollmentStatus;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record EnrollmentDTO(
        Long id,
        @NotNull
        Long studentId,
        @NotNull
        Long courseId,
        @NotNull
        LocalDate enrollmentDate,
        @NotNull
        EnrollmentStatus status) {}