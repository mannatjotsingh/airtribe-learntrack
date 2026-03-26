package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {

	private ArrayList<Enrollment> enrollments = new ArrayList<>();

	public void enrollStudent(int studentId, int courseId, StudentService studentService, CourseService courseService)
			throws EntityNotFoundException {

		studentService.findById(studentId);
		courseService.findById(courseId);

		Enrollment e = new Enrollment(IdGenerator.getEnrollmentId(), studentId, courseId);

		enrollments.add(e);
	}
	
	public void viewEnrollmentsByStudent(int studentId) {
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                System.out.println("Course ID: " + e.getCourseId());
            }
        }
    }
	public void markEnrollmentStatus(int studentId, int courseId, EnrollmentStatus status)
	        throws EntityNotFoundException {

	    for (Enrollment e : enrollments) {
	        if (e.getStudentId() == studentId && e.getCourseId() == courseId) {
	            e.setStatus(status);
	            System.out.println("Status updated to " + status);
	            return;
	        }
	    }
	    throw new EntityNotFoundException("Enrollment not found");
	}
}
