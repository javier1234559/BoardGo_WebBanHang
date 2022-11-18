package entities;

public class findProductByID{

	private int id ;
	private int name ;
	
	public findProductByID() {
	}
	public findProductByID(int id, int name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	
}
