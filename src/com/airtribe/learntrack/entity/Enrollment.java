package com.airtribe.learntrack.entity;

import java.time.LocalDateTime;

public class Enrollment {
	private int id;
	private int studentId;
	private int courseId;
	private EnrollmentStatus status;

	public Enrollment(int id, int studentId, int courseId) {
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
		this.status = EnrollmentStatus.ACTIVE;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setStatus(EnrollmentStatus status) {
		this.status = status;
	}
}
