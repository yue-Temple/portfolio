package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DTO.OrderDetail;
import system.ItemCalc;
import system.TankCalc;

public class Checkmonyview {

	public Viewable execute(Map<String, Object> inputData,
			Map<String, Object> outputData,
			Map<String, Object> sharedData) {

		//インスタンス生成
		Scanner scan = new Scanner(System.in);
		ItemCalc itemcalc = new ItemCalc();

		//型キャスト
		List<OrderDetail> orderdetail = (List<OrderDetail>) inputData.get("order_array");

		//合計金額計算・表示
		int money = itemcalc.price_calc(orderdetail);
		System.out.println("計：" + money + "円");

		//確認
		String flag = "null";
		while (!flag.equals("y") && !flag.equals("n")) {
			System.out.println("確認しましたか？ y/n");
			flag = itemcalc.inputcheck2(scan.nextLine());
		}

		if (flag.equals("y")) {

			//カウンター更新
			sharedData.put("counts", ((Integer) sharedData.get("counts") + orderdetail.get(0).getOnebuy()));
			sharedData.put("countt", (Integer) sharedData.get("countt") + orderdetail.get(1).getOnebuy());
			sharedData.put("countb", (Integer) sharedData.get("countb") + orderdetail.get(2).getOnebuy());
			sharedData.put("SUM", (Integer) sharedData.get("SUM") + money);

			//タンク更新処理
			TankCalc tankcalc = new TankCalc();
			int tank = tankcalc.amountcalc((Integer) sharedData.get("tank"), orderdetail.get(0).getOnebuy(),
					orderdetail.get(1).getOnebuy(), orderdetail.get(2).getOnebuy());

			//スコープに格納
			inputData.put("money", money);
			sharedData.put("tank", tank);

			//金額計算に飛ぶ
			return new SalesResultView().execute(inputData, outputData, sharedData);
		} else {
			//商品表示に飛ぶ（戻る）
			return new ProductNameInputFormView().execute(inputData, outputData, sharedData);
		}

	}

}
