package service;

import java.util.ArrayList;

import DTO.Product;

public class CalcService {
	ProductDAO productdao = new ProductDAO();

	// 商品ごとの会計,可変長配列(int,int,int)
	public ArrayList<Integer> Calc(String[] buy_order) {
		ArrayList<Integer> pricelist = new ArrayList<Integer>();
		ArrayList<Product> productlist = productdao.selectAll();

		for (int i = 0; productlist.size() > i; i++) {
			//リストpricelist = 商品の値段＊商品を買った数
			pricelist.add(productlist.get(i).getUnitPrice() * Integer.parseInt(buy_order[i]));
		}

		return pricelist;//商品インスタンスの配列
	}

	// 商品ごとの通算購入数
	public ArrayList<Integer> Calctotal(ArrayList<Integer> befortotallist, ArrayList<Integer> pricelist) {
		ArrayList<Integer> totalorderlist = new ArrayList<Integer>();

		for (int i = 0; pricelist.size() > i; i++) {
			totalorderlist.add(befortotallist.get(i) + pricelist.get(i));
		}

		return totalorderlist;//商品インスタンスの配列
	}

	//お釣り計算
	public int change_calc(int money, int pay) {
		int change = pay - money;
		return change;
	}

	//金額不足時falseを返す
	public boolean checkinput(int change) {
		boolean flag = false;
		if (change >= 0) {
			flag = true;
		}
		return flag;
	}

	//金種計算
	public int[] moneytype(int change) {
		//貨幣計算		
		int[] moneytype = { 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] moneyCount = new int[moneytype.length];

		for (int i = 0; i < moneyCount.length; i++) {
			moneyCount[i] = change / moneytype[i];
			change %= moneytype[i];
		}
		return moneyCount;
	}

}
