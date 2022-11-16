package entities;

public class Product {

    private long id;
    private String title ;
    private long price;
    private String color;
    private String category;
    private int productrank;
    private int favorite;
    private String description;
    private String image;

    public Product() {

    }

    
	public Product(long id, String title, long price, String color, String category, int productrank, int favorite,String description, String image) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.color = color;
		this.category = category;
		this.productrank = productrank;
		this.favorite = favorite;
		this.description = description;
		this.image = image;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductrank() {
		return productrank;
	}

	public void setProductrank(int productrank) {
		this.productrank = productrank;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
    
}
