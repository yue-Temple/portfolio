package view;

import java.util.Map;
import java.util.Scanner;

import system.ItemCalc;

public class Chengeview {

	public Viewable execute(Map<String, Object> inputData,
			Map<String, Object> outputData,
			Map<String, Object> sharedData) {

		int money = (Integer) inputData.get("money");
		int pay = (Integer) inputData.get("pay");

		//インスタンスの生成
		ItemCalc itemcalc = new ItemCalc();

		//お釣りの計算
		int change = itemcalc.change_calc(money, pay);
		int[] moneytype = itemcalc.moneytype(change);

		System.out.println(pay + "-" + money + "=" + change);

		//表示
		System.out.println("--- お釣り表示 ---");
		System.out.println("5000| ×" + moneytype[0]);
		System.out.println("2000| ×" + moneytype[1]);
		System.out.println("1000| ×" + moneytype[2]);
		System.out.println(" 500| ×" + moneytype[3]);
		System.out.println(" 100| ×" + moneytype[4]);
		System.out.println("  50| ×" + moneytype[5]);
		System.out.println("  10| ×" + moneytype[6]);
		System.out.println("   5| ×" + moneytype[7]);
		System.out.println("   1| ×" + moneytype[8]);
		System.out.println("お釣り：" + change + "円");
		System.out.println("＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿");
		System.out.println("");

		//確認
		System.out.println("続けて入力しますか？ y/n");
		Scanner scan = new Scanner(System.in);
		String flag = scan.nextLine();

		if (flag.equals("y")) {
			//商品入力に戻る
			return new ProductNameInputFormView().execute(inputData, outputData, sharedData);
		} else {
			//結果表示に飛ぶ
			return new AllResult().execute(inputData, outputData, sharedData);
		}

	}

}
