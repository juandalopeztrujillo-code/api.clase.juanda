package co.edu.cesde.coursemanagment.application.service;

import co.edu.cesde.coursemanagment.application.dto.EnrollmentDTO;
import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO create(Long id, Long studentId, Long courseId);
    EnrollmentDTO findById(Long id);
    List<EnrollmentDTO> findAll();
    EnrollmentDTO cancelEnrollment(Long id);
    void delete(Long id);
}