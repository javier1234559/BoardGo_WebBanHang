package entities;

public class Cart {
	private Product pro;
	private int quantity;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	public Product getPro() {
		return pro;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setPro(Product pro) {
		this.pro = pro;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}