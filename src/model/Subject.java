package model;

public class Subject {

	private int id;
	private String name;
	private int fkIdTeacher;
	private int fkIdSemester;

	public Subject() {

	}

	public Subject(String name, int fkIdTeacher, int fkIdSemester) {
		this.name = name;
		this.fkIdTeacher = fkIdTeacher;
		this.fkIdSemester = fkIdSemester;
	}

	public Subject(int id, String name, int fkIdTeacher, int fkIdSemester) {
		this.id = id;
		this.name = name;
		this.fkIdTeacher = fkIdTeacher;
		this.fkIdSemester = fkIdSemester;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFkIdTeacher() {
		return fkIdTeacher;
	}

	public void setFkIdTeacher(int fkIdTeacher) {
		this.fkIdTeacher = fkIdTeacher;
	}

	public int getFkIdSemester() {
		return fkIdSemester;
	}

	public void setFkIdSemester(int fkIdSemester) {
		this.fkIdSemester = fkIdSemester;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", fkIdTeacher=" + fkIdTeacher + ", fkIdSemester="
				+ fkIdSemester + "]";
	}
	

}
