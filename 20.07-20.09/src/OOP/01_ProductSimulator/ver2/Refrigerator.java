package com.ssafy.hw.day07;

public class Refrigerator extends Product {
	private int size;
	private int height;
	public Refrigerator(String sireal, String pname, int price, int stock,int size,int height) {
		super(sireal, pname, price, stock);
		this.size=size;
		this.height=height;
		// TODO Auto-generated constructor stub
	}

	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "냉장고 [상품번호=" + super.getSireal() + ", 상품명=" + super.getPname()+ 
				", 가격=" + super.getPrice()+", 수량=" + super.getStock() +
				", 용량=" + this.size + "+, 높이=" + this.height + "]";
	}
}
