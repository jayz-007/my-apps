package com.techlabs.model;

import java.util.Comparator;

public class DesignationComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		String s = o1.getRole();
		return s.compareToIgnoreCase(o2.getRole());
	}

}