package com.ssafy.hw.day07;

public class Tv extends Product{
	private int inch;
	private String displaySize;
	public Tv(String sireal, String pname, int price, int stock,int inch,String displaySize) {
		super(sireal, pname, price, stock);
		this.inch=inch;
		this.displaySize=displaySize;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	@Override
	public String toString() {
		return "TV [상품번호=" + super.getSireal() + ", 상품명=" + super.getPname()+ 
				", 가격=" + super.getPrice()+", 수량=" + super.getStock() +
				", 인치=" + inch + "+, 해상도=" + displaySize + "]";
	}
	
	
}
