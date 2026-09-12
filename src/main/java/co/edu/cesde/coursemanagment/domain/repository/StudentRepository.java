package co.edu.cesde.coursemanagment.domain.repository;

import co.edu.cesde.coursemanagment.domain.models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void deleteById(Long id);
}