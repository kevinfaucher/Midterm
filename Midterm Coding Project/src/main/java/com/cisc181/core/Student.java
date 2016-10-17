package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

import Exceptions.PersonException;

public class Student extends Person {

	private eMajor Major;
	private UUID StudentID;

	public eMajor geteMajor() {
		return this.Major;
	}

	public void seteMajor(eMajor Major) {
		this.Major = Major;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public Student(String FirstName, String MiddleName, String LastName, Date DOB, eMajor Major, String Address,
			String Phone_number, String Email, UUID StudentID) throws PersonException {
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.Major = Major;

	}

	@Override
	public void PrintName() {
		System.out.println(getLastName() + "," + getFirstName() + ' ' + getMiddleName());
	}

	public void PrintName(boolean bnormal) {
		super.PrintName();
	}
}