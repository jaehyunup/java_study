package com.ssafy.hw.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductTest {
	private static Scanner sc=new Scanner(System.in);
	public IProductMgr DAO=ProductMgrImpl.getInstance();
	public void service() {
		System.out.println("------Abc 디지털 대리점 재고관리 서비스------");
		while (true) {
			int mode=printMenu();
			String serial,pname;
			int price,stocks;
			List<Product> result=new ArrayList<Product>();
			sc.nextLine();
			switch(mode) {
			case 1:
				System.out.println("제품타입 1.TV 2.냉장고");
				int productStyle=Integer.parseInt(sc.nextLine());
				System.out.println("제품명");
				pname=sc.nextLine();
				System.out.println("제품번호");
				serial=sc.nextLine();
				System.out.println("가격");
				price=Integer.parseInt(sc.nextLine());
				System.out.println("재고수량");
				stocks=Integer.parseInt(sc.nextLine());
				if(productStyle==1) {
					System.out.println("인치");
					int inch=Integer.parseInt(sc.nextLine());
					System.out.println("해상도");
					String displaySize=sc.nextLine();
					DAO.add(new Tv(serial,pname,price,stocks,inch,displaySize));
				}else if(productStyle==2){
					System.out.println("용량");
					int size=Integer.parseInt(sc.nextLine());
					System.out.println("높이");
					int height=Integer.parseInt(sc.nextLine());
					DAO.add(new Refrigerator(serial,pname,price,stocks,size,height));
				}
				System.out.println(pname+" 상품이 추가되었습니다.");
				break;
			case 2:
				System.out.println("삭제할 제품번호를 적어주세요 ");
				serial=sc.nextLine();
				if(DAO.delete(serial)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
				break;
			case 3:
				printProducts(DAO.SelectAll());
				break;
			case 4:
				System.out.println("찾을 상품의 제품번호를 적어주세요 ");
				serial=sc.nextLine();
				printProducts(DAO.SelectBySerial(serial));
				break;
			case 5:
				System.out.println("찾을 상품의 상품명을 적어주세요 ");
				pname=sc.nextLine();
				printProducts(DAO.SelectByName(pname));
				break;
			case 6:
				printProducts(DAO.SelectAllTv());
				break;
			case 7:
				printProducts(DAO.SelectAllRefrigerator());
				break;
			case 8:
				System.out.println("재고상품의 총 금액은 "+DAO.SelectAllstocks()+" 원 입니다.");
				break;
			case 9:
				System.out.println("찾을 상품의 제품번호를 적어주세요 ");
				serial=sc.nextLine();
				System.out.println("변경할 가격을 적어주세요");
				price=Integer.parseInt(sc.nextLine());
				if(DAO.updateProduct(serial, price)) {
					System.out.println("수정완료");
				}else {
					System.out.println("제품이 존재하지 않습니다!");
				}
				break;
			case 10:
				printProducts(DAO.SelectOver400L());
				break;
			case 11:
				printProducts(DAO.SelectOver50inch());
				break;
			case 12:
				System.exit(1);
				break;
			}
		}
	}
	
	private void printProducts(List<Product> resultList) {
		if(resultList.size()>0) {
			for (Product product : resultList) {
				System.out.println(product.toString());
			}
		}else {
			System.out.println("제품이 존재하지 않습니다!");
		}
	}
	
	
	public int printMenu() {
		System.out.println("----------1.상품정보 추가하기------------");
		System.out.println("----------2.상품정보 삭제하기------------");
		System.out.println("----------3.상품정보 전체보기------------");
		System.out.println("--------4.상품정보 검색(상품번호)--------");
		System.out.println("---------5.상품정보 검색(상품명)--------");
		System.out.println("---------6.TV상품만 전체보기------------");
		System.out.println("---------7.냉장고 상품만 전체보기--------");
		System.out.println("---------8.전체 재고 총 금액 확인--------");
		System.out.println("---------9.상품 가격 변경 하기 --------");
		System.out.println("---------10.400리터 이상냉장고검색 --------");
		System.out.println("---------11.50인치 이상 Tv 검색--------");
		System.out.println("---------------12.종료---------------");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		ProductTest test=new ProductTest();
		test.service();

	}

}
