package model;

public class Studying {
	private int fkIdStudent;
	private int fkIdSubject;
	
	public Studying() {
		
	}
	public Studying(int fkIdStudent, int fkIdSubject) {
		this.fkIdStudent = fkIdStudent;
		this.fkIdSubject = fkIdSubject;
	}
	public int getFkIdStudent() {
		return fkIdStudent;
	}
	public void setFkIdStudent(int fkIdStudent) {
		this.fkIdStudent = fkIdStudent;
	}
	public int getFkIdSubject() {
		return fkIdSubject;
	}
	public void setFkIdSubject(int fkIdSubject) {
		this.fkIdSubject = fkIdSubject;
	}
	@Override
	public String toString() {
		return "Studying [fkIdStudent=" + fkIdStudent + ", fkIdSubject=" + fkIdSubject + "]";
	}	
}
