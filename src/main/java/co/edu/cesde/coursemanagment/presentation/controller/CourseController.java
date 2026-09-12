package co.edu.cesde.coursemanagment.presentation.controller;

import co.edu.cesde.coursemanagment.application.dto.CourseDTO;
import co.edu.cesde.coursemanagment.application.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) {
        CourseDTO created = courseService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @Valid @RequestBody CourseDTO dto) {
        return ResponseEntity.ok(courseService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}