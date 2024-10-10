package view;

import java.util.Map;
import java.util.Scanner;

import system.TankCalc;

public class AllResult {

	public Viewable execute(Map<String, Object> inputData,
			Map<String, Object> outputData,
			Map<String, Object> sharedData) {

		TankCalc tankcalc = new TankCalc();
		//型キャスト
		int counts = (Integer) sharedData.get("counts");
		int countt = (Integer) sharedData.get("countt");
		int countb = (Integer) sharedData.get("countb");
		int allcoffee = tankcalc.alltank(counts, countt, countb);

		System.out.println("---商品集計情報---");
		System.out.println("スモール販売個数:" + sharedData.get("counts"));
		System.out.println("　トール販売個数:" + sharedData.get("countt"));
		System.out.println("　ビッグ販売個数:" + sharedData.get("countb"));
		System.out.println("");
		System.out.println("合計消費量:" + allcoffee + "ml");
		System.out.println("合計売上金額:" + sharedData.get("SUM"));
		System.out.println("");
		System.out.println("");

		Scanner scan = new Scanner(System.in);
		String flag = "n";//システム終了フラグ

		while (flag.equals("n")) {
			System.out.println("システムを終了しますか? y/n");
			flag = scan.nextLine();
		}

		return null;
	}

}
