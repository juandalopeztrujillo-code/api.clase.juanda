package co.edu.cesde.coursemanagment.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public record CreateStudentDTO(
        @NotNull
        Long id,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @NotBlank
        @Email
        String email,

        @NotNull
        @Past
        LocalDate birthDate
) {}
