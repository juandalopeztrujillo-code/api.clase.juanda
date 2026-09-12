package co.edu.cesde.coursemanagment.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateCourseDTO(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        @Min(1)
        Integer credits
) {}