package com.techlabs.model.test;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import com.techlabs.model.*;

public class Test {

	public static void main(String[] args) throws ParseException, IOException {
		DataExtract u = new DataExtract();
		u.getDataFromSource("https://swabhav-tech.firebaseapp.com/emp.txt", "dataFile_emp.txt");
		Collection<Employee> tree = u.getEmployees();
		Employee richEmp = null;

		for (Employee employee : tree) {
			richEmp = employee;
		}
		for (Employee e : tree) {
			if (richEmp.getSalary() < e.getSalary()) {
				richEmp = e;
			}
		}
		System.out.println("Total No. of Employee in Organization:" + tree.size());
		System.out.println("\nMaximum Salaried Employee Details!");
		System.out.println(richEmp);
//		writeIntoCsv(tree);
		countEmpAccordingDesignation(tree);
		countEmpAccordingDeptNo(tree);
	}

	private static void countEmpAccordingDeptNo(Collection<Employee> tree) {
		System.out.println("\nTotal Count According to DeptNo!");
		TreeSet<Employee> uniqueDeptNo = new TreeSet(new DeptComparator());
		for (Employee e : tree) {
			uniqueDeptNo.add(e);
		}
		for(Employee e : uniqueDeptNo) {
			System.out.println("Depto no : " +e.getDeptno() + " name is : " + e.getEname());
		}
		for (Employee e : uniqueDeptNo) {
			int count = 0;
			for (Employee e1 : tree) {
				if (e.getDeptno() == e1.getDeptno()) {
					count++;
				}
			}
			System.out.println("DeptNo " + e.getDeptno() + " has " + count);
		}
	}

	private static void countEmpAccordingDesignation(Collection<Employee> tree) {
		TreeSet<Employee> uniqueDesignation = new TreeSet(new DesignationComparator());
		System.out.println("\nTotal Count According to Designation!");
		for (Employee e : tree) {
			uniqueDesignation.add(e);
		}
		String designation = "n";
		int count = 0;
		for (Employee e : uniqueDesignation) {
			if (designation.contentEquals(e.getRole())) {
				System.out.println("count++");
				count++;
			} else {
				if (!(designation.contentEquals("n"))) {
					System.out.println("Designation is: " + designation + "Count is : " + count);
				}

				designation = e.getRole();
				count = 1;
			}
		}

	}

	private static void writeIntoCsv(Collection<Employee> tree) throws IOException {
		FileWriter fw = new FileWriter("Employee.csv");
		fw.write(
				" Employee_id,Employee_name,Employee_designation,Manager_id,Date_of_joining,Salary,Commission,Departmentnumber\n");
		for (Employee e : tree) {
			fw.write(e.getEid() + "," + e.getEname() + "," + e.getRole() + "," + e.getManagerId() + "," + e.getDoj()
					+ "," + e.getSalary() + "," + e.getComm() + "," + e.getDeptno() + "\n");
		}
		fw.close();
		System.out.println("\nFile created");
	}
}