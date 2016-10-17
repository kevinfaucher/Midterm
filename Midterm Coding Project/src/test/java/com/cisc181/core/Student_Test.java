package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import Exceptions.PersonException;

public class Student_Test {

	static ArrayList<Student> student = new ArrayList<Student>();
	static ArrayList<Course> course = new ArrayList<Course>();
	static ArrayList<Semester> semester = new ArrayList<Semester>();
	static ArrayList<Section> section = new ArrayList<Section>();

	static ArrayList<Enrollment> orgo101 = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> posc101 = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> orgo200 = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> posc202 = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> phys301 = new ArrayList<Enrollment>();
	static ArrayList<Enrollment> orgo401 = new ArrayList<Enrollment>();

	public static Date newSem(int year, int month, int day) {
		Calendar calender_two = Calendar.getInstance();
		calender_two.set(year, month, day);
		return calender_two.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException {

		Course posc = new Course(UUID.randomUUID(), "Political Science", 101, eMajor.BUSINESS);
		Course orgo = new Course(UUID.randomUUID(), "Organic Chemistry", 101, eMajor.CHEM);
		Course phys = new Course(UUID.randomUUID(), "Physics", 101, eMajor.PHYSICS);

		// added courses to list
		course.add(posc);
		course.add(orgo);
		course.add(phys);

		Semester fall_2017 = new Semester(UUID.randomUUID(), newSem(2016, 8, 30), newSem(2016, 12, 9));
		Semester spring_2018 = new Semester(UUID.randomUUID(), newSem(2017, 2, 10), newSem(2017, 5, 26));

		semester.add(spring_2018);
		semester.add(fall_2017);

		// Fall/Spring Sections
		Section fall_posc = new Section(posc.getCourseID(), fall_2017.getSemesterID(), UUID.randomUUID(), 101);
		Section fall_orgo = new Section(orgo.getCourseID(), fall_2017.getSemesterID(), UUID.randomUUID(), 101);
		Section fall_phys = new Section(phys.getCourseID(), fall_2017.getSemesterID(), UUID.randomUUID(), 101);

		Section spring_posc = new Section(posc.getCourseID(), spring_2018.getSemesterID(), UUID.randomUUID(), 201);
		Section spring_orgo = new Section(orgo.getCourseID(), spring_2018.getSemesterID(), UUID.randomUUID(), 201);
		Section spring_phys = new Section(phys.getCourseID(), spring_2018.getSemesterID(), UUID.randomUUID(), 201);

		section.add(fall_posc);
		section.add(fall_orgo);
		section.add(fall_phys);
		section.add(spring_posc);
		section.add(spring_orgo);
		section.add(spring_phys);

		Student student_one = new Student("Kylo", "Darth", "Renn", newSem(1991, 3, 17), eMajor.BUSINESS,
				"1 Star Dsryer", "(555)-1111-4217", "darkside@comcast.net", UUID.randomUUID());

		Student student_two = new Student("Luke", "Ben", "Skywalker", newSem(1996, 11, 19), eMajor.CHEM, "4 IV TAT",
				"(555)-322-2204", "shouldagoneonmaury@udel.edu", UUID.randomUUID());

		Student student_three = new Student("Harry", "James", "Peterson", newSem(1995, 13, 9), eMajor.COMPSI,
				"North Hg Way", "(555)-555-1100", "itsmagic@udel.edu", UUID.randomUUID());

		Student student_four = new Student("Tedd", "Talks", "Rock", newSem(1996, 4, 2), eMajor.NURSING, "11 Frosty Way",
				"(555)-125-3441", "tedtalkstoo@gmail.com", UUID.randomUUID());

		Student student_five = new Student("Johnson", "Mike", "Buddy", newSem(1995, 4, 22), eMajor.CHEM,
				"96 Lve Street", "(555)-214-0242", "nottajohnson@yahoo.com", UUID.randomUUID());

		Student student_six = new Student("Peter", "Perry", "Penway", newSem(1996, 6, 20), eMajor.PHYSICS,
				"Plenty Ps Plazza", "(555)-544-4554", "pepepe@udel.edu", UUID.randomUUID());

		Student student_seven = new Student("Mike", "Douge", "Jones", newSem(1995, 4, 14), eMajor.PHYSICS,
				"Bfor Rcrod Del", "(555)-844-4432", "dogey@yahoo.com", UUID.randomUUID());

		Student student_eight = new Student("Matt", "Martian", "Damon", newSem(1996, 2, 20), eMajor.CHEM,
				"100 Red Planet", "(555)-262-6949", "couldusealift@gmail.com", UUID.randomUUID());

		Student student_nine = new Student("Pyvat", "Par", "Arts", newSem(1992, 3, 21), eMajor.COMPSI, "100 Ntch Lane",
				"(555)-446-4838", "arts@udel.edu", UUID.randomUUID());

		Student student_ten = new Student("Machoman", "Randy", "Savage", newSem(1994, 11, 28), eMajor.CHEM,
				"2 macho forme", "(555)-113-1501", "mostlymacho@aol.com", UUID.randomUUID());

		student.add(student_one);
		student.add(student_two);
		student.add(student_three);
		student.add(student_four);
		student.add(student_five);
		student.add(student_six);
		student.add(student_seven);
		student.add(student_eight);
		student.add(student_nine);
		student.add(student_ten);

		// List of student grades
		ArrayList<Integer> grades_set_one = new ArrayList<Integer>(
				Arrays.asList(99, 72, 81, 95, 99, 82, 77, 83, 55, 93));
		ArrayList<Integer> grade_set_two = new ArrayList<Integer>(
				Arrays.asList(95, 86, 68, 92, 69, 98, 89, 47, 83, 93));
		ArrayList<Integer> grade_set_three = new ArrayList<Integer>(
				Arrays.asList(99, 79, 69, 47, 64, 97, 93, 99, 90, 56));

		for (int ch = 0; ch < student.size(); ch++) {

			orgo101.add(new Enrollment(section.get(0).getSectionID(), student.get(ch).getStudentID()));
			orgo101.get(ch).setGrade(grades_set_one.get(ch));

			posc101.add(new Enrollment(section.get(1).getSectionID(), student.get(ch).getStudentID()));
			posc101.get(ch).setGrade(grade_set_two.get(ch));

			orgo200.add(new Enrollment(section.get(2).getSectionID(), student.get(ch).getStudentID()));
			orgo200.get(ch).setGrade(grade_set_three.get(ch));

			posc202.add(new Enrollment(section.get(3).getSectionID(), student.get(ch).getStudentID()));
			posc202.get(ch).setGrade(grades_set_one.get(ch));

			phys301.add(new Enrollment(section.get(4).getSectionID(), student.get(ch).getStudentID()));
			phys301.get(ch).setGrade(grade_set_two.get(ch));

			orgo401.add(new Enrollment(section.get(5).getSectionID(), student.get(ch).getStudentID()));
			orgo401.get(ch).setGrade(grade_set_three.get(ch));
		}

	}

	// Student GPA calculation
	public double calcStudentGPA(ArrayList<Enrollment> orgo101, ArrayList<Enrollment> posc101,
			ArrayList<Enrollment> orgo200, ArrayList<Enrollment> posc202, ArrayList<Enrollment> phys301,
			ArrayList<Enrollment> orgo401, int Student) {
		final int courseNumber = 6;

		double gpa = 0;

		if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 95) {
			gpa = 4.0;
		} else if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 90) {
			gpa = 3.75;
		} else if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 85) {
			gpa = 3.50;
		} else if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 80) {
			gpa = 3.00;
		} else if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 75) {
			gpa = 2.50;
		} else if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 70) {
			gpa = 2.00;
		} else if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 65) {
			gpa = 1.50;
		} else if ((orgo101.get(Student).getGrade() + posc101.get(Student).getGrade() + orgo200.get(Student).getGrade()
				+ posc202.get(Student).getGrade() + phys301.get(Student).getGrade() + orgo401.get(Student).getGrade())
				/ courseNumber >= 60) {
			gpa = 1.00;
		} else {
			gpa = 0.00;
		}
		return gpa;
	}

	// GPA tests
	@Test
	public void StudentGPATest() {
		assertEquals(4.0, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 0), .001);
		assertEquals(2.0, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 1), .001);
		assertEquals(0.0, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 2), .001);
		assertEquals(3.75, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 3), .001);
		assertEquals(2.0, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 4), .001);
		assertEquals(3.5, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 5), .001);
		assertEquals(2.5, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 6), .001);
		assertEquals(1.5, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 7), .001);
		assertEquals(3.0, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 8), .001);
		assertEquals(1.0, calcStudentGPA(orgo101, posc101, orgo200, posc202, phys301, orgo401, 9), .001);
	}

	public static double courseAverage(ArrayList<Enrollment> courses) {

		double avg = 0;
		double courseAvg = 0;

		for (int y = 0; y < student.size(); y++) {
			avg += courses.get(y).getGrade();
			courseAvg = (avg / student.size());
		}
		return courseAvg;
	}

	// Avg grades
	@Test
	public void testGrades() {
		assertEquals(75.4, courseAverage(orgo101), .01);
		assertEquals(76.7, courseAverage(posc101), 01);
		assertEquals(75.2, courseAverage(orgo200), .01);
		assertEquals(75.4, courseAverage(posc202), .01);
		assertEquals(76.7, courseAverage(phys301), 01);
		assertEquals(75.2, courseAverage(orgo401), .01);
	}

	public static void majorChange(eMajor maj, Student stu) {
		stu.seteMajor(maj);
	}

	@Test
	public void testMajorChangeStudent() {
		majorChange(eMajor.CHEM, student.get(5));
		assertEquals(eMajor.CHEM, student.get(5).geteMajor());
	}

}