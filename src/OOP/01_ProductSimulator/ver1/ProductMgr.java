package com.ssafy.hw.day06;

import java.util.Arrays;

public class ProductMgr {
	private static ProductMgr Instance;
	private Product[] productList = new Product[3];
	private int index;

	public static ProductMgr getInstance() {
		if (Instance == null) {
			Instance = new ProductMgr();
		}
		return Instance;
	}

	/* CRUD */
	public void add(Product p) {
		if (index > productList.length) { // 공간추가가 더 필요하다면
			int newSpace = index + 10; // 10씩 더해준다
			Product[] TempList = Arrays.copyOf(productList, newSpace);
			productList = TempList;
		}
		productList[index++] = p;
	}

	/* 상품번호로 상품을 삭제 */
	public boolean delete(String serial) {
		for (int i = 0; i < productList.length; i++) {
			if (productList[i].getSireal().equals(serial)) {
				int mvcnt = index - (i + 1);
				if (mvcnt != 0) {
					System.arraycopy(productList, i + 1, productList, i, mvcnt);
				}
				productList[index--] = null;
				return true;
			}
		}
		return false;
	}

	// 상품이름 상품검색
	public Product[] SelectByName(String name) {
		int tempidx = 0;
		boolean flag = false;
		Product[] tempProductArr = new Product[index];
		
		for(int i=0;i<index;i++) {
			if(productList[i].getPname().contains((name))) {
				flag = true;
				tempProductArr[tempidx++] = productList[i];
			}
		}
		if (flag) {
			return Arrays.copyOfRange(tempProductArr,0,tempidx);
		} else {
			return null;
		}
	}

	// 상품번호 상품검색
	public Product[] SelectBySerial(String serial) {
		int tempidx = 0;
		boolean flag = false;
		Product[] tempProductArr = new Product[index];
		for(int i=0;i<index;i++) {
			if(productList[i].getSireal().equals((serial))) {
				flag = true;
				tempProductArr[tempidx++] = productList[i];
			}
		}
		if (flag) {
			return Arrays.copyOfRange(tempProductArr,0,tempidx);
		} else {
			return null;
		}
	}

	//
	public Product[] SelectAllTv() {
		int tempidx = 0;
		boolean flag = false;
		Product[] tempTvArr = new Product[index];
		for(int i=0;i<index;i++) {
			if(productList[i] instanceof Tv){
				flag = true;
				tempTvArr[tempidx++] =productList[i];
			}
		}
		if (flag) {
			return Arrays.copyOfRange(tempTvArr,0,tempidx);
		} else {
			return null;
		}
	}

	public Product[] SelectAllRefrigerator() {
		int tempidx = 0;
		boolean flag = false;
		Product[] tempRefrigeratorArr = new Product[index];
		for(int i=0;i<index;i++) {
			if(productList[i] instanceof Refrigerator){
				flag = true;
				tempRefrigeratorArr[tempidx++] =productList[i];
			}
		}
		if (flag) {
			return Arrays.copyOfRange(tempRefrigeratorArr,0,tempidx);
		} else {
			return null;
		}
	}

	public int SelectAllstocks() {
		int stocksSum=0;
		for(int i=0;i<index;i++) {
			stocksSum+= productList[i].getStock()*productList[i].getPrice();
		}
		return stocksSum;
	}

	public Product[] SelectAll() {
		return Arrays.copyOf(productList, index);
	}
}
