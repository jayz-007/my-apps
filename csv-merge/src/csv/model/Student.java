package csv.model;

public class Student {
	private int id;
	private int rollno;
	private String name;

	public Student(int id, String name, int rollno) {
		this.id = id;
		this.name = name;
		this.rollno = rollno;

	}

	public int getId() {
		return id;

	}

	public String getName() {
		return name;

	}

	public int getRollNo() {
		return rollno;

	}

}
