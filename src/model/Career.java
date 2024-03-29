package model;

public class Career {
	private int id;
	private String name;

	public Career() {

	}
	public Career(String name){
		this.setName(name);;
	}
	public Career(int id, String name) {
		this(name);
		this.setId(id);;
	}

	public int getId() {
		return this.id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Career [id=" + id + ", name=" + name + "]";
	}
}
