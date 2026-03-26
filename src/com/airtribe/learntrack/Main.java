package com.airtribe.learntrack;

import java.util.Scanner;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
public class Main {

	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);

	        StudentService studentService = new StudentService();
	        CourseService courseService = new CourseService();
	        EnrollmentService enrollmentService = new EnrollmentService();

	        while (true) {

	            System.out.println("\n==== MAIN MENU ====");
	            System.out.println("1. Student Management");
	            System.out.println("2. Course Management");
	            System.out.println("3. Enrollment Management");
	            System.out.println("4. Exit");

	            int choice = sc.nextInt();

	            try {
	                switch (choice) {

	                    case 1:
	                        studentMenu(sc, studentService);
	                        break;

	                    case 2:
	                        courseMenu(sc, courseService);
	                        break;

	                    case 3:
	                        enrollmentMenu(sc, studentService, courseService, enrollmentService);
	                        break;

	                    case 4:
	                        return;

	                    default:
	                        System.out.println("Invalid option");
	                }

	            } catch (EntityNotFoundException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (Exception e) {
	                System.out.println("Invalid input");
	                sc.nextLine(); // clear buffer
	            }
	        }
	    }

	    // ================= STUDENT MENU =================
	    private static void studentMenu(Scanner sc, StudentService studentService)
	            throws EntityNotFoundException {

	        System.out.println("\n-- Student Management --");
	        System.out.println("1. Add Student");
	        System.out.println("2. View Students");
	        System.out.println("3. Search Student by ID");
	        System.out.println("4. Deactivate Student");

	        int choice = sc.nextInt();

	        switch (choice) {

	            case 1:
	                System.out.print("First Name: ");
	                String fn = sc.next();
	                System.out.print("Last Name: ");
	                String ln = sc.next();

	                studentService.addStudent(new Student(
	                        IdGenerator.getStudentId(),
	                        fn, ln, "test@mail.com", "Batch A"
	                ));
	                System.out.println("Student added successfully");
	                break;

	            case 2:
	                studentService.listStudents();
	                break;

	            case 3:
	                System.out.print("Enter Student ID: ");
	                int id = sc.nextInt();
	                studentService.searchStudentById(id);
	                break;

	            case 4:
	                System.out.print("Enter Student ID: ");
	                int did = sc.nextInt();
	                studentService.deactivateStudent(did);
	                break;

	            default:
	                System.out.println("Invalid option");
	        }
	    }

	    // ================= COURSE MENU =================
	    private static void courseMenu(Scanner sc, CourseService courseService)
	            throws EntityNotFoundException {

	        System.out.println("\n-- Course Management --");
	        System.out.println("1. Add Course");
	        System.out.println("2. View Courses");
	        System.out.println("3. Activate/Deactivate Course");

	        int choice = sc.nextInt();

	        switch (choice) {

	            case 1:
	                System.out.print("Course Name: ");
	                String name = sc.next();

	                courseService.addCourse(new Course(
	                        IdGenerator.getCourseId(),
	                        name, "desc", 10
	                ));
	                System.out.println("Course added");
	                break;

	            case 2:
	                courseService.listCourses();
	                break;

	            case 3:
	                System.out.print("Enter Course ID: ");
	                int id = sc.nextInt();
	                courseService.toggleCourseStatus(id);
	                break;

	            default:
	                System.out.println("Invalid option");
	        }
	    }

	    // ================= ENROLLMENT MENU =================
	    private static void enrollmentMenu(Scanner sc,
	                                       StudentService studentService,
	                                       CourseService courseService,
	                                       EnrollmentService enrollmentService)
	            throws EntityNotFoundException {

	        System.out.println("\n-- Enrollment Management --");
	        System.out.println("1. Enroll Student");
	        System.out.println("2. View Enrollments by Student");
	        System.out.println("3. Update Enrollment Status");

	        int choice = sc.nextInt();

	        switch (choice) {

	            case 1:
	                System.out.print("Student ID: ");
	                int sid = sc.nextInt();
	                System.out.print("Course ID: ");
	                int cid = sc.nextInt();

	                enrollmentService.enrollStudent(sid, cid, studentService, courseService);
	                System.out.println("Enrollment successful");
	                break;

	            case 2:
	                System.out.print("Student ID: ");
	                int vid = sc.nextInt();
	                enrollmentService.viewEnrollmentsByStudent(vid);
	                break;

	            case 3:
	                System.out.print("Student ID: ");
	                int usid = sc.nextInt();
	                System.out.print("Course ID: ");
	                int ucid = sc.nextInt();

	                System.out.println("1. COMPLETED\n2. CANCELLED");
	                int statusChoice = sc.nextInt();

	                EnrollmentStatus status = (statusChoice == 1)
	                        ? EnrollmentStatus.COMPLETED
	                        : EnrollmentStatus.CANCELLED;

	                enrollmentService.markEnrollmentStatus(usid, ucid, status);
	                break;

	            default:
	                System.out.println("Invalid option");
	        }
	    }
	}