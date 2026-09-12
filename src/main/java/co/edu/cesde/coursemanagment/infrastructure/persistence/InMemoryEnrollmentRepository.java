package co.edu.cesde.coursemanagment.infrastructure.persistence;

import co.edu.cesde.coursemanagment.domain.models.Enrollment;
import co.edu.cesde.coursemanagment.domain.repository.EnrollmentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryEnrollmentRepository implements EnrollmentRepository {
    private final Map<Long, Enrollment> storage = new HashMap<>();

    @Override
    public Enrollment save(Enrollment enrollment) {
        storage.put(enrollment.getId(), enrollment);
        return enrollment;
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }
}