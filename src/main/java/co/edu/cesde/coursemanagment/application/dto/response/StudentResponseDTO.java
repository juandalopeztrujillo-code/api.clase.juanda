package co.edu.cesde.coursemanagment.application.dto.response; // Ajusta el paquete según lo tengas en tu estructura

import java.time.LocalDate;

public record StudentResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        LocalDate birthDate
) {}