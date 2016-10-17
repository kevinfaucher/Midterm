package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	UUID SectionID, StudentID, EnrollmentID;
	private double Grade;

	private Enrollment() {

	}

	public Enrollment(UUID StudentID, UUID SectionID) {
		this();
		this.StudentID = SectionID;
		this.SectionID = StudentID;
		this.EnrollmentID = UUID.randomUUID();

	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID secID) {
		this.SectionID = secID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public void setStudentID(UUID stuID) {
		this.StudentID = stuID;
	}

	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public void setEnrollmentID(UUID enrollID) {
		this.EnrollmentID = enrollID;
	}

	public double getGrade() {
		return Grade;
	}

	public void setGrade(double gde) {
		this.Grade = gde;
	}

}