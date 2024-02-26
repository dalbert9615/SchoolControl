package model;

public class Rating {
	
	public enum enuTypes{GLOBAL,PARCIAL}
	
	private int id;
	private int grade;
	private enuTypes type;
	private int fkIdAlumno;
	private int fkIdMateria;
	
	public Rating() {
	}
	
	public Rating(int id, int grade, enuTypes type, int fkIdAlumno, int fkIdMateria) {
		this.id = id;
		this.grade = grade;
		this.type = type;
		this.fkIdAlumno = fkIdAlumno;
		this.fkIdMateria = fkIdMateria;
	}

	public Rating(int grade, enuTypes type, int fkIdAlumno, int fkIdMateria) {
		this.grade = grade;
		this.type = type;
		this.fkIdAlumno = fkIdAlumno;
		this.fkIdMateria = fkIdMateria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public enuTypes getType() {
		return type;
	}

	public void setType(enuTypes type) {
		this.type = type;
	}

	public int getFkIdAlumno() {
		return fkIdAlumno;
	}

	public void setFkIdAlumno(int fkIdAlumno) {
		this.fkIdAlumno = fkIdAlumno;
	}

	public int getFkIdMateria() {
		return fkIdMateria;
	}

	public void setFkIdMateria(int fkIdMateria) {
		this.fkIdMateria = fkIdMateria;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", grade=" + grade + ", type=" + type + ", fkIdAlumno=" + fkIdAlumno
				+ ", fkIdMateria=" + fkIdMateria + "]";
	}	
}
