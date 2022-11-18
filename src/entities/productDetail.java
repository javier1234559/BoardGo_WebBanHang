package entities;

import java.awt.Color;

public class productDetail {

	private int idimage;
	private int idproduct;
	private String color;
	private int soluong;
	private String image;
	
	public productDetail() {}

	public productDetail(int idimage, int idproduct, String color, int soluong, String image) {
		super();
		this.idimage = idimage;
		this.idproduct = idproduct;
		this.color = color;
		this.soluong = soluong;
		this.image = image;
	}

	public int getIdimage() {
		return idimage;
	}

	public void setIdimage(int idimage) {
		this.idimage = idimage;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
