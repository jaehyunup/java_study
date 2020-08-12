package com.ssafy.hw.day06;

public class Refrigerator extends Product {
	private int size;
	private int height;
	public Refrigerator(String sireal, String pname, int price, int stock,int size,int height) {
		super(sireal, pname, price, stock);
		this.size=size;
		this.height=height;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "냉장고 [상품번호=" + super.getSireal() + ", 상품명=" + super.getPname()+ 
				", 가격=" + super.getPrice()+", 수량=" + super.getStock() +
				", 용량=" + this.size + "+, 높이=" + this.height + "]";
	}
}
