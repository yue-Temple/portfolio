package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import DTO.OrderDetail;
import DTO.Product;
import system.ItemCalc;

//商品購入数入力
public class ProductNameInputFormView implements Viewable {

	@Override
	public Viewable execute(Map<String, Object> inputData,
			Map<String, Object> outputData,
			Map<String, Object> sharedData) {

		Scanner scan = new Scanner(System.in);
		ItemCalc itemcalc = new ItemCalc();
		Product[] product_array = itemcalc.product();

		//商品の入力
		//戻り値はOrderDetailインスタンスの配列
		System.out.println("▼購入数の入力");
		List<OrderDetail> orderdetail = itemcalc.item_input();

		//スコープに格納
		inputData.put("product_array", product_array);
		inputData.put("order_array", orderdetail);

		return new Checkmonyview().execute(inputData, outputData, sharedData);

	}

}
