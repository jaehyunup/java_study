package com.ssafy.hw.day07;

import java.util.Arrays;
import java.util.List;

public interface IProductMgr {
	/* CRUD */
	public void add(Product p);
	/* 상품번호로 상품을 삭제 */
	public boolean delete(String serial);
	// 상품이름 상품검색
	public List<Product> SelectByName(String name);
	// 상품번호 상품검색
	public List<Product> SelectBySerial(String serial);
	public List<Product> SelectAllTv();
	public List<Product> SelectAllRefrigerator();
	public List<Product> SelectOver400L();
	public List<Product> SelectOver50inch();
	public int SelectAllstocks();
	public List<Product> SelectAll();
	
	public boolean updateProduct(String serial,int price);
	
}
