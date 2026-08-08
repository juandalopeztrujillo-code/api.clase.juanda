package co.edu.cesde.coursemanagment.application.dto;


import java.time.LocalDate;

public record StudentDTO(Long id, String firstName, String lastName, String email, LocalDate birthDate) {}
