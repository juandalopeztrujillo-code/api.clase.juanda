package co.edu.cesde.coursemanagment.infrastructure.persistence;





import co.edu.cesde.coursemanagment.domain.models.Student;
import co.edu.cesde.coursemanagment.domain.repository.StudentRepository;

import java.util.*;



public class InMemoryStudentRepository implements StudentRepository {
    private final Map<Long, Student> storage = new HashMap<>();

    @Override
    public Student save(Student student) {
        storage.put(student.getId(), student);
        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }
}
