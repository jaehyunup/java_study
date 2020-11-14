package com.ssafy.hw.day06;

public class Product {
	private String serial;
	private String pname;
	private int price;
	private int stocks;
	
	
	public Product(String sireal, String pname, int price, int stock) {
		super();
		this.serial = sireal;
		this.pname = pname;
		this.price = price;
		this.stocks = stock;
	}
	public String getSireal() {
		return serial;
	}
	public void setSireal(String sireal) {
		this.serial = sireal;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stocks;
	}
	public void setStock(int stock) {
		this.stocks = stock;
	}

	@Override
	public String toString() {
		return "상품 [상품번호=" + serial + ", 상품명=" + pname + ", 가격=" + price + ", 수량=" + stocks + "]";
	}
	
}
