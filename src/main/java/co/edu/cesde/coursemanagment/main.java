package co.edu.cesde.coursemanagment;

import co.edu.cesde.coursemanagment.application.service.CourseService;
import co.edu.cesde.coursemanagment.application.service.EnrollmentService;
import co.edu.cesde.coursemanagment.application.service.StudentService;
import co.edu.cesde.coursemanagment.infrastructure.persistence.InMemoryCourseRepository;
import co.edu.cesde.coursemanagment.infrastructure.persistence.InMemoryEnrollmentRepository;
import co.edu.cesde.coursemanagment.infrastructure.persistence.InMemoryStudentRepository;
import co.edu.cesde.coursemanagment.presentation.ConsoleMenu;

public class main {
    public static void main(String[] args) {
        // 1. Inicialización de los repositorios en memoria (Infraestructura)
        var studentRepository = new InMemoryStudentRepository();
        var courseRepository = new InMemoryCourseRepository();
        var enrollmentRepository = new InMemoryEnrollmentRepository();

        // 2. Inicialización de los servicios (Aplicación)
        var studentService = new StudentService(studentRepository);
        var courseService = new CourseService(courseRepository);
        var enrollmentService = new EnrollmentService(enrollmentRepository, studentService, courseService);

        // 3. Inicialización y ejecución del menú por consola (Presentación)
        var consoleMenu = new ConsoleMenu(studentService, courseService, enrollmentService);
        consoleMenu.start();
    }
}

