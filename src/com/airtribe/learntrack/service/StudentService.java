package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentService {

	private ArrayList<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public Student findById(int id) throws EntityNotFoundException {
		for (Student s : students) {
			if (s.getId() == id)
				return s;
		}
		throw new EntityNotFoundException("Student with ID " + id + " not found");
	}
	public void searchStudentById(int id) throws EntityNotFoundException {
	    Student s = findById(id);
	    System.out.println(s.getId() + " - " + s.getDisplayName());
	}


	public void listStudents() {
		if (students.isEmpty()) {
			System.out.println("No students found");
			return;
		}
		for (Student s : students) {
			System.out.println(s.getId() + " - " + s.getDisplayName());
		}
	}

	public void deactivateStudent(int id) throws EntityNotFoundException {
		Student s = findById(id);
		s.deactivate();
	    System.out.println("Student deactivated successfully");

	}
	public void updateStudent(int id, String newFirstName, String newLastName)
	        throws EntityNotFoundException {

	    Student s = findById(id);

	    if (newFirstName != null) s.setFirstName(newFirstName);
	    if (newLastName != null) s.setLastName(newLastName);
	}
}
