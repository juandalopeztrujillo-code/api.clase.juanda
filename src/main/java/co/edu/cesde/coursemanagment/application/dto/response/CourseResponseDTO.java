package co.edu.cesde.coursemanagment.application.dto.response;

public record CourseResponseDTO(
        Long id,
        String title,
        String description,
        Integer credits
) {}