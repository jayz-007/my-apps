package com.techlabs.model;

import java.util.Comparator;

public class DeptComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getDeptno() == o2.getDeptno()) {
			return 0;
		}
		if(o1.getDeptno()>o1.getDeptno())
			return 1;
		return -1;
	}
}