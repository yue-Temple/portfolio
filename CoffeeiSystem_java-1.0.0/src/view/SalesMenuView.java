package view;

import java.util.Map;

//4. システムは、商品を表示する。
public class SalesMenuView implements Viewable {

	public Viewable execute(Map<String, Object> inputData, Map<String, Object> outputData,
			Map<String, Object> sharedData) {

		//商品の表示
		System.out.println("---商品情報---");
		System.out.println("スモール: 120円");
		System.out.println("トール　: 190円");
		System.out.println("ビッグ　: 250円");
		System.out.println("");

		return new ProductNameInputFormView().execute(inputData, outputData, sharedData);

	}
}
