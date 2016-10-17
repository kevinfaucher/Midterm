package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import Exceptions.PersonException;

public class Staff_Test {

	// Staff list

	static ArrayList<Staff> staff1 = new ArrayList<Staff>();

	public static Date newDate(int yr, int mon, int day) {
		Calendar cal2 = Calendar.getInstance();
		cal2.set(yr, mon, day);
		return cal2.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException {

		staff1.add(new Staff("Mike", "Chup", "Frost", newDate(1967, 8, 12), "North Street", "(555)-814-2525",
				"mchup@hotmail.com", "MW 8:00-10:00am", 2, 60000, newDate(2012, 3, 24), eTitle.MR));

		staff1.add(new Staff("Tom", "Rose", "Thorn", newDate(1977, 7, 25), "East Street", "(555)-557-8997",
				"everyrose@yahoo.com", "T 6:00-8:00pm", 4, 40000, newDate(2013, 4, 21), eTitle.MR));

		staff1.add(new Staff("Elena", "Tess", "Sullivan", newDate(1964, 10, 12), "South Street", "(555)-016-0133",
				"unele@aol.com", "WF 2:00-8:00pm", 2, 50000, newDate(1992, 11, 16), eTitle.MRS));

		staff1.add(new Staff("Ellie", "Alice", "Cooper", newDate(1987, 9, 29), "West Street", "(555)-420-4004",
				"rckon@gmail.com", "T 9:00-10:00am", 3, 75000, newDate(1995, 5, 12), eTitle.MRS));

		staff1.add(new Staff("Adam", "Savage", "Jones", newDate(1966, 9, 29), "Tested Street", "(555)-345-6789",
				"maker@gmail.com", "M 7:00-11:00am", 2, 41000, newDate(1990, 13, 12), eTitle.MR));
	}

	@Test
	public void testSalary() throws PersonException {
		double netVal = 0;
		for (Staff averageStaff : staff1) {
			netVal += averageStaff.getSalary();
		}
		double average = netVal / staff1.size();
		assertEquals(average, 51420, .01);
	}

	@Test(expected = PersonException.class)
	public void testDOBException() throws PersonException {

		new Staff("Mike", "Chup", "Frost", newDate(1865, 8, 12), "North Street", "(555)-814-2525", "mchup@hotmail.com",
				"MW 8:00-10:00am", 2, 60000, newDate(2012, 3, 24), eTitle.MR);
		new Staff("Elena", "Tess", "Sullivan", newDate(1774, 10, 12), "South Street", "(555)-016-0133", "unele@aol.com",
				"WF 2:00-8:00pm", 2, 50000, newDate(1992, 11, 16), eTitle.MRS);
	}

	@Test(expected = PersonException.class)
	public void phoneNumException() throws PersonException {
		new Staff("Adam", "Savage", "Jones", newDate(1967, 9, 29), "Tested Street", "555-345-6789", "maker@gmail.com",
				"M 7:00-11:00am", 2, 41000, newDate(1990, 13, 12), eTitle.MR);
		new Staff("Ellie", "Alice", "Cooper", newDate(1967, 9, 29), "West Street", "555-420-4004", "rckon@gmail.com",
				"T 9:00-10:00am", 3, 75000, newDate(1995, 5, 12), eTitle.MRS);
	}
}