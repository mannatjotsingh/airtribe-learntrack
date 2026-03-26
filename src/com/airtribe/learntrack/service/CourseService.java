package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

	private ArrayList<Course> courses = new ArrayList<>();

	public void addCourse(Course course) {
		courses.add(course);
	}

	public Course findById(int id) throws EntityNotFoundException {
		for (Course c : courses) {
			if (c.getId() == id)
				return c;
		}
		throw new EntityNotFoundException("Course with ID " + id + " not found");
	}

	public void listCourses() {
		if (courses.isEmpty()) {
			System.out.println("No courses found");
			return;
		}
		for (Course c : courses) {
			System.out.println(c.getId() + " - " + c.getCourseName());
		}
	}

	public void toggleCourseStatus(int id) throws EntityNotFoundException {
		Course c = findById(id);

		if (c.isActive()) {
			c.deactivate();
			System.out.println("Course deactivated");
		} else {
			c.activate();
			System.out.println("Course activated");
		}
	}
}