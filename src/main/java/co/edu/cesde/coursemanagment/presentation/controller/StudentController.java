package co.edu.cesde.coursemanagment.presentation.controller;

import co.edu.cesde.coursemanagment.application.dto.StudentDTO;
import co.edu.cesde.coursemanagment.application.dto.CreateStudentDTO;
import co.edu.cesde.coursemanagment.application.dto.UpdateStudentDTO;
import co.edu.cesde.coursemanagment.application.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody CreateStudentDTO dto) {
        StudentDTO created = studentService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id, @Valid @RequestBody UpdateStudentDTO dto) {
        return ResponseEntity.ok(studentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}