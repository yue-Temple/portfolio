package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DTO.Order;
import DTO.OrderDetail;
import DTO.Product;
import system.ItemCalc;

public class SalesResultView {

	public Viewable execute(Map<String, Object> inputData,
			Map<String, Object> outputData,
			Map<String, Object> sharedData) {

		//インスタンス生成
		Scanner scan = new Scanner(System.in);
		Order order = new Order();
		ItemCalc itemcalc = new ItemCalc();

		//型キャスト
		List<OrderDetail> orderdetail = (List<OrderDetail>) inputData.get("order_array");
		Product[] product_array = (Product[]) inputData.get("product_array");
		
		
		//注文番号更新
		int orderNo = itemcalc.orderNoUpdate((Integer)sharedData.get("orderNo"));
		sharedData.put("orderNo", orderNo);

		System.out.println("--- 販売結果 ---");
		System.out.println("注文番号:【NO_" + String.format("%06d", orderNo) + " 】");
		System.out.println("注文日時:【" + order.getOrderTime() + " 】");
		System.out.println("担当者情報:【ID：" + sharedData.get("id") + " 】");
		System.out.println("タンク残量:【" + sharedData.get("tank") + " ml】");
		System.out.println("");

		for (int i = 0; i < orderdetail.size(); i++) {
			System.out.println(orderdetail.get(i).getProduct().getPrice() + " 円 * " + orderdetail.get(i).getOnebuy());
		}

		System.out.println("----------------");
		System.out.println("計）" + inputData.get("money") + " 円");
		System.out.println("");

		//客から受け取った金額の入力
		System.out.print("受け取り金額の入力：");
		int pay = scan.nextInt();//客が払ったお金

		//受取金額を渡す。
		inputData.put("pay", pay);

		//お釣り表示に飛ぶ
		return new Chengeview().execute(inputData, outputData, sharedData);

	}

}
