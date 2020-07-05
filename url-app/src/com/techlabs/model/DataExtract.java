package com.techlabs.model;


import java.net.*;
import java.text.ParseException;
import java.util.Collection;
import java.util.TreeSet;
import java.io.*;

public class DataExtract {

	TreeSet<String> list = new TreeSet();
	TreeSet<Employee> employees = new TreeSet<Employee>();

	public void getDataFromSource(String theUrl, String fileName) throws ParseException, IOException {

		BufferedReader b = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = b.readLine()) != null) {
			list.add(line);
		}
		URL url = new URL(theUrl);
		b = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((line = b.readLine()) != null) {
			list.add(line);
		}
		b.close();
		for (String str : list) {
			String[] elements = str.split(",");
			int empId = Integer.parseInt(elements[0]);
			String eName = elements[1].replaceAll("'", "");
			String role = elements[2].replaceAll("'", "");
			int managerId = 0;
			if (!elements[3].equals("NULL")) {
				managerId = Integer.parseInt(elements[3]);
			}
			String doj = elements[4].replaceAll("'", "");
			int salary = Integer.parseInt(elements[5]);
			int comm = 0;
			if (!elements[6].equals("NULL")) {
				comm = Integer.parseInt(elements[6]);
			}
			int deptId = Integer.parseInt(elements[7]);
			employees.add(new Employee(empId, eName, role, managerId, doj, salary, comm, deptId));
		}
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}
}