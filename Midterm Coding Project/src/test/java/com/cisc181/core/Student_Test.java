package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import Exceptions.PersonException;

public class Student_Test {

	@BeforeClass
	public static void setup() throws PersonException {
		Course class1 = new Course();
		Course class2 = new Course();
		Course class3 = new Course();
		ArrayList classList = new ArrayList();
		classList.add(class1);
		classList.add(class2);
		classList.add(class3);
		UUID id1 = UUID.randomUUID();
		Date semdate1 = new Date();
		Date semdate2 = new Date();
		Semester fall = new Semester(id1, semdate1, semdate2);
		Semester spring = new Semester(id1, semdate1, semdate2);
		ArrayList semList = new ArrayList();
		semList.add(fall);
		semList.add(spring);
		Section c1s = new Section(id1, id1, id1, 5);
		Section c1f = new Section(id1, id1, id1, 5);
		Section c2s = new Section(id1, id1, id1, 5);
		Section c2f = new Section(id1, id1, id1, 5);
		Section c3s = new Section(id1, id1, id1, 5);
		Section c3f = new Section(id1, id1, id1, 5);
		ArrayList<Section> secList = new ArrayList<Section>();
		secList.add(c1s);
		secList.add(c2s);
		secList.add(c3s);
		secList.add(c1f);
		secList.add(c2f);
		secList.add(c3f);
		
		
		Student student_one = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_two = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_three = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_four = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_five = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_six = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_seven = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_eight = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_nine = new Student(null, null, null, semdate2, null, null, null, null);
		Student student_ten = new Student(null, null, null, semdate2, null, null, null, null);
		ArrayList<Student> student_List = new ArrayList<Student>();
		
		
		student_List.add(student_one);
		student_List.add(student_two);
		student_List.add(student_three);
		student_List.add(student_four);
		student_List.add(student_five);
		student_List.add(student_six);
		student_List.add(student_seven);
		student_List.add(student_eight);
		student_List.add(student_nine);
		student_List.add(student_ten);
		for (Student s : student_List)
			new Enrollment(s.getStudentID(), c1s.getSectionID());

	}

	@Test
	public void test() {
		assertEquals(1, 1);
	}
}