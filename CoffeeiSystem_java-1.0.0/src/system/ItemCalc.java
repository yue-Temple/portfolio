package system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.OrderDetail;
import DTO.Product;

public class ItemCalc {

	Scanner scan = new Scanner(System.in);

	//商品設定（商品ID,商品名,値段,容量）
	Product SMALL = new Product("item1", "スモール", 120, 120);
	Product TOUR = new Product("item2", "トール", 190, 220);
	Product BIG = new Product("item3", "ビッグ", 250, 300);

	Product[] product_array = new Product[] { SMALL, TOUR, BIG };

	//商品インスタンス配列を返すメソッド
	public Product[] product() {
		return product_array;
	}

	//商品購入数の入力
	public List<OrderDetail> item_input() {

		String buyamount = null;
		OrderDetail orderDetail = null;
		List<OrderDetail> order_array = new ArrayList<OrderDetail>();

		for (int i = 0; i < product_array.length; i++) {
			boolean flag = false;
			while (!flag) {
				System.out.print(product_array[i].getName() + "の購入数：");
				buyamount = scan.nextLine();//購入数の入力
				flag = inputcheck(buyamount);//入力確認メソッドの呼び出し	
			}
			orderDetail = new OrderDetail(Integer.parseInt(buyamount), product_array[i]);

			order_array.add(orderDetail);
		}
		return order_array;
	}

	//入力確認メソッド(商品購入数の入力メソッドで利用)
	public boolean inputcheck(String buyamount) {
		if (!buyamount.matches("[0-9]+")) {
			System.out.println("無効な文字が入力されました。入力をやりなおしてください。");
			System.out.println("");
			return false;
		} else {
			return true;
		}
	}

	//入力確認メソッド(Checkmonyviewの進行確認で利用)
	public String inputcheck2(String yorn) {
		if (!yorn.matches("y") && !yorn.matches("n")) {
			System.out.println("無効な文字が入力されました。y/nで入力してください。");
			return "null";
		} else if (yorn.matches("n")) {
			System.out.println("では商品入力に戻ります…");
			System.out.println("");
			return "n";
		} else {
			return "y";
		}
	}

	//合計金額計算
	public int price_calc(List<OrderDetail> order_array) {
		int money = 0;
		for (int i = 0; i < product_array.length; i++) {
			money += product_array[i].getPrice() * order_array.get(i).getOnebuy();
		}
		return money;
	}

	//お釣り計算
	public int change_calc(int money, int pay) {

		//金額不足時
		while (pay < money) {
			System.out.println("金額が不足しています。再度入力してください。");
			System.out.print("受け取り金額の入力：");
			pay = scan.nextInt();
		}

		int change = pay - money;
		return change;
	}

	//金種計算
	public int[] moneytype(int money) {
		//貨幣計算		
		int[] moneytype = { 5000, 2000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] moneyCount = new int[moneytype.length];

		for (int i = 0; i < moneyCount.length; i++) {
			moneyCount[i] = money / moneytype[i];
			money %= moneytype[i];
		}

		return moneyCount;
	}

	//注文番号更新
	public int orderNoUpdate(int _orderNo) {
		_orderNo = _orderNo + 1;
		return _orderNo;
	}

}
