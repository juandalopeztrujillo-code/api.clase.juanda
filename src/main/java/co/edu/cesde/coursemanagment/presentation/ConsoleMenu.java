package co.edu.cesde.coursemanagment.presentation;

import co.edu.cesde.coursemanagment.application.dto.CourseDTO;
import co.edu.cesde.coursemanagment.application.dto.StudentDTO;
import co.edu.cesde.coursemanagment.application.service.CourseService;
import co.edu.cesde.coursemanagment.application.service.EnrollmentService;
import co.edu.cesde.coursemanagment.application.service.StudentService;
import co.edu.cesde.coursemanagment.domain.exceptions.BusinessException;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleMenu {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    public void start() {
        int option = -1;
        do {
            System.out.println("\n================ MAIN MENU ================");
            System.out.println("1. Students");
            System.out.println("2. Courses");
            System.out.println("3. Enrollments");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> studentMenu();
                    case 2 -> courseMenu();
                    case 3 -> enrollmentMenu();
                    case 0 -> System.out.println("Exiting application...");
                    default -> System.out.println("❌ Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Please enter a valid integer number.");
            }
        } while (option != 0);
    }

    private void studentMenu() {
        int option = -1;
        do {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Create");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");
            System.out.print("Select option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.print("First Name: "); String fn = scanner.nextLine();
                        System.out.print("Last Name: "); String ln = scanner.nextLine();
                        System.out.print("Email: "); String email = scanner.nextLine();
                        studentService.create(new StudentDTO(id, fn, ln, email, LocalDate.now()));
                        System.out.println("✅ Student created successfully.");
                    }
                    case 2 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(studentService.findById(id));
                    }
                    case 3 -> courseService.findAll().forEach(System.out::println);
                    case 4 -> {
                        System.out.print("ID to Update: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.print("New First Name: "); String fn = scanner.nextLine();
                        System.out.print("New Last Name: "); String ln = scanner.nextLine();
                        System.out.print("New Email: "); String email = scanner.nextLine();
                        studentService.update(id, new StudentDTO(id, fn, ln, email, LocalDate.now()));
                        System.out.println("✅ Student updated successfully.");
                    }
                    case 5 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        studentService.delete(id);
                        System.out.println("✅ Student deleted successfully.");
                    }
                    case 0 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("❌ Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Input must be a valid number.");
            } catch (BusinessException e) {
                System.out.println("❌ Business Error: " + e.getMessage());
            }
        } while (option != 0);
    }

    private void courseMenu() {
        int option = -1;
        do {
            System.out.println("\n--- COURSE MENU ---");
            System.out.println("1. Create");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");
            System.out.print("Select option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.print("Code: "); String code = scanner.nextLine();
                        System.out.print("Name: "); String name = scanner.nextLine();
                        System.out.print("Description: "); String desc = scanner.nextLine();
                        System.out.print("Max Capacity: "); Integer cap = Integer.parseInt(scanner.nextLine());
                        courseService.create(new CourseDTO(id, code, name, desc, cap));
                        System.out.println("✅ Course created successfully.");
                    }
                    case 2 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(courseService.findById(id));
                    }
                    case 3 -> courseService.findAll().forEach(System.out::println);
                    case 4 -> {
                        System.out.print("ID to Update: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.print("New Code: "); String code = scanner.nextLine();
                        System.out.print("New Name: "); String name = scanner.nextLine();
                        System.out.print("New Description: "); String desc = scanner.nextLine();
                        System.out.print("New Max Capacity: "); Integer cap = Integer.parseInt(scanner.nextLine());
                        courseService.update(id, new CourseDTO(id, code, name, desc, cap));
                        System.out.println("✅ Course updated successfully.");
                    }
                    case 5 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        courseService.delete(id);
                        System.out.println("✅ Course deleted successfully.");
                    }
                    case 0 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("❌ Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Input must be a valid number.");
            } catch (BusinessException e) {
                System.out.println("❌ Business Error: " + e.getMessage());
            }
        } while (option != 0);
    }

    private void enrollmentMenu() {
        int option = -1;
        do {
            System.out.println("\n--- ENROLLMENT MENU ---");
            System.out.println("1. Create Enrollment");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Cancel Enrollment");
            System.out.println("5. Delete Enrollment");
            System.out.println("0. Back");
            System.out.print("Select option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1 -> {
                        System.out.print("Enrollment ID: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.print("Student ID: "); Long sId = Long.parseLong(scanner.nextLine());
                        System.out.print("Course ID: "); Long cId = Long.parseLong(scanner.nextLine());
                        enrollmentService.create(id, sId, cId);
                        System.out.println("✅ Enrollment created successfully.");
                    }
                    case 2 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        System.out.println(enrollmentService.findById(id));
                    }
                    case 3 -> courseService.findAll().forEach(System.out::println);
                    case 4 -> {
                        System.out.print("ID to Cancel: "); Long id = Long.parseLong(scanner.nextLine());
                        enrollmentService.cancelEnrollment(id);
                        System.out.println("✅ Enrollment cancelled successfully.");
                    }
                    case 5 -> {
                        System.out.print("ID: "); Long id = Long.parseLong(scanner.nextLine());
                        enrollmentService.delete(id);
                        System.out.println("✅ Enrollment deleted successfully.");
                    }
                    case 0 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("❌ Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Input must be a valid number.");
            } catch (BusinessException e) {
                System.out.println("❌ Business Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}

