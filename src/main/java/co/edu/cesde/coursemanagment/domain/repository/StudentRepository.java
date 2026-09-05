package co.edu.cesde.coursemanagment.domain.repository;


import co.edu.cesde.coursemanagment.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student save(Student student);

    Optional<Student> findByStudentId(Long studentId);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    boolean existsByStudentId(Long studentId);

    void deleteById(Long id);

    Optional<Student> update(Student student);

    boolean existsByEmail(String email);
}
