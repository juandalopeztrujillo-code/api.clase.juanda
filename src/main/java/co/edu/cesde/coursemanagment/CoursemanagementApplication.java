package co.edu.cesde.coursemanagment;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CoursemanagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CoursemanagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        System.out.println("Sistema de Gestión de Cursos Iniciado.");

        // Menú Principal
        while (option != 0) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Students");
            System.out.println("2. Courses");
            System.out.println("3. Enrollments");
            System.out.println("0. Exit");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> showStudentMenu(scanner);
                    case 2 -> showCourseMenu(scanner);
                    case 3 -> showEnrollmentMenu(scanner);
                    case 0 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor ingresa un número válido.");
                scanner.next();
            }
        }
        scanner.close();
        System.exit(0);
    }

    // Menú Estudiantes
    private void showStudentMenu(Scanner scanner) {
        int option = -1;
        while (option != 0) {
            System.out.println("\n--- MENÚ ESTUDIANTES ---");
            System.out.println("1. Crear");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Listar Todos");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> System.out.println("Funcionalidad 'Crear Estudiante' pendiente");
                    case 2 -> System.out.println("Funcionalidad 'Buscar por ID' pendiente...");
                    case 3 -> System.out.println("Funcionalidad 'Listar Todos' pendiente...");
                    case 4 -> System.out.println("Funcionalidad 'Actualizar' pendiente...");
                    case 5 -> System.out.println("Funcionalidad 'Eliminar' pendiente...");
                    case 0 -> System.out.println("Volviendo al Menú Principal...");
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor ingresa un número válido.");
                scanner.next();
            }
        }
    }

    // Menú Cursos
    private void showCourseMenu(Scanner scanner) {
        int option = -1;
        while (option != 0) {
            System.out.println("\n--- MENÚ CURSOS ---");
            System.out.println("1. Crear");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Listar Todos");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> System.out.println("Funcionalidad 'Crear Curso' pendiente...");
                    case 2 -> System.out.println("Funcionalidad 'Buscar por ID' pendiente...");
                    case 3 -> System.out.println("Funcionalidad 'Listar Todos' pendiente...");
                    case 4 -> System.out.println("Funcionalidad 'Actualizar' pendiente...");
                    case 5 -> System.out.println("Funcionalidad 'Eliminar' pendiente...");
                    case 0 -> System.out.println("Volviendo al Menú Principal...");
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor ingresa un número válido.");
                scanner.next();
            }
        }
    }

    // Menú Matrículas
    private void showEnrollmentMenu(Scanner scanner) {
        int option = -1;
        while (option != 0) {
            System.out.println("\n--- MENÚ MATRÍCULAS ---");
            System.out.println("1. Crear Matrícula");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Listar Todos");
            System.out.println("4. Cancelar Matrícula");
            System.out.println("5. Eliminar Matrícula");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> System.out.println("Funcionalidad 'Crear Matrícula' pendiente...");
                    case 2 -> System.out.println("Funcionalidad 'Buscar por ID' pendiente...");
                    case 3 -> System.out.println("Funcionalidad 'Listar Todos' pendiente...");
                    case 4 -> System.out.println("Funcionalidad 'Cancelar Matrícula' pendiente...");
                    case 5 -> System.out.println("Funcionalidad 'Eliminar Matrícula' pendiente...");
                    case 0 -> System.out.println("Volviendo al Menú Principal...");
                    default -> System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor ingresa un número válido.");
                scanner.next();
            }
        }
    }
}

