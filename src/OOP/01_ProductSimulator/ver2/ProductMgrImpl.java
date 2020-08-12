package com.ssafy.hw.day07;

import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {
	private static ProductMgrImpl Instance;
	private List<Product> productList = new ArrayList<Product>();

	public static ProductMgrImpl getInstance() {
		if (Instance == null) {
			Instance = new ProductMgrImpl();
		}
		return Instance;
	}

	@Override
	public void add(Product p) {
		productList.add(p);
	}

	@Override
	public boolean delete(String serial) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getSireal().equals(serial)) {
				productList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Product> SelectByName(String name) {
		List<Product> result=new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getPname().equals(name)) {
				result.add(productList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<Product> SelectBySerial(String serial) {
		List<Product> result=new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getSireal().equals(serial)) {
				result.add(productList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<Product> SelectAllTv() {
		List<Product> result=new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i) instanceof Tv) {
				result.add(productList.get(i));
			}
		}
		return result;
	}
	
	@Override
	public List<Product> SelectAllRefrigerator() {
		List<Product> result=new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i) instanceof Refrigerator) {
				result.add(productList.get(i));
			}
		}
		return result;
	}
	
	@Override
	public int SelectAllstocks() {
		int stocksSum=0;
		for (int i = 0; i < productList.size(); i++) {
			stocksSum+= productList.get(i).getStock()*productList.get(i).getPrice();
		}
		return stocksSum;
	}
	
	@Override
	public List<Product> SelectAll() {
		return productList;
	}

	@Override
	public boolean updateProduct(String serial, int price) {
		int idx=0;
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getSireal().equals(serial)) {
				productList.get(i).setPrice(price);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Product> SelectOver400L() {
		List<Product> result=new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i) instanceof Refrigerator &&
					((Refrigerator)productList.get(i)).getSize() > 400) {
				result.add(productList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<Product> SelectOver50inch() {
		List<Product> result=new ArrayList<Product>();
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i) instanceof Tv &&
					((Tv)productList.get(i)).getInch() > 50) {
				result.add(productList.get(i));
			}
		}
		return result;		
	}
}

