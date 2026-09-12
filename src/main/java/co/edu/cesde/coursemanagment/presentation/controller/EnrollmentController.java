package co.edu.cesde.coursemanagment.presentation.controller;

import co.edu.cesde.coursemanagment.application.dto.EnrollmentDTO;
import co.edu.cesde.coursemanagment.application.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> create(
            @RequestParam Long id,
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        EnrollmentDTO created = enrollmentService.create(id, studentId, courseId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() {
        return ResponseEntity.ok(enrollmentService.findAll());
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<EnrollmentDTO> cancelEnrollment(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.cancelEnrollment(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
