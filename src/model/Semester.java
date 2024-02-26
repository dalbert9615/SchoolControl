package model;

public class Semester {
	private int id;
	private int number;
	private int fkIdCarrer;
	
	public Semester() {
	}
	
	public Semester(int number, int fkIdCarrer) {
		this.number = number;
		this.fkIdCarrer = fkIdCarrer;
	}
	
	public Semester(int id, int number, int fkIdCarrer) {
		this.id = id;
		this.number = number;
		this.fkIdCarrer = fkIdCarrer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFkIdCarrer() {
		return fkIdCarrer;
	}
	public void setFkIdCarrer(int fkIdCarrer) {
		this.fkIdCarrer = fkIdCarrer;
	}
	@Override
	public String toString() {
		return "Semester [id=" + id + ", number=" + number + ", fkIdCarrer=" + fkIdCarrer + "]";
	}	
}
