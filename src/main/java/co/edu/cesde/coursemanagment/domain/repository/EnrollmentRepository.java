package co.edu.cesde.coursemanagment.domain.repository;



import co.edu.cesde.coursemanagment.domain.models.Enrollment;
import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {
    Enrollment save(Enrollment enrollment);
    Optional<Enrollment> findById(Long id);
    List<Enrollment> findAll();
    void deleteById(Long id);
}
