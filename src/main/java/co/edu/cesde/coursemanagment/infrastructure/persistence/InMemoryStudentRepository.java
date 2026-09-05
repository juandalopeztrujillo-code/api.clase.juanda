package co.edu.cesde.coursemanagment.infrastructure.persistence;

import co.edu.cesde.coursemanagment.domain.models.Student;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public  class InMemoryStudentRepository {
    private final Map<Long, Student> storage = new HashMap<>();


    public Student save(Student student) {
        storage.put(student.getId(), student);
        return student;
    }


    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }


    public List<Student> findAll() {
        return new ArrayList<>(storage.values());
    }


    public void deleteById(Long id) {
        storage.remove(id);
    }
}
