package model;

public class Career {
	private int id;
	private String name;	
	
	public Career() {
	
	}

	public Career(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	private int getId() {
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
}
