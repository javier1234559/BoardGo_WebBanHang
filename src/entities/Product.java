package entities;

public class Product {

    private int idproduct;
    private String nameproduct ;
    private long price;
    private String category;
    private String image; // 1 pic hinh co ban

    public Product() {

    }

	public Product(int idproduct, String nameproduct, long price, String category, String image) {
		super();
		this.idproduct = idproduct;
		this.nameproduct = nameproduct;
		this.price = price;
		this.category = category;
		this.image = image;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public String getNameproduct() {
		return nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
