package csv.model;

import java.util.ArrayList;

public class StudentDB {
	private CSVLoader csv;
	ArrayList<Student> students1 = new ArrayList<Student>();

	public StudentDB(CSVLoader csv) {
		this.csv = csv;
	}
	public void createDb() {
		ArrayList<String > lines = (ArrayList<String>) csv.getList();
		
	}

}
