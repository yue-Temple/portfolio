package system;

import java.util.HashMap;
import java.util.Map;

import view.SalesMenuView;

public class Start2 {

	public static void main(String[] args) {

		//インスタンスの生成
		Login login = new Login();
		SalesMenuView smv = new SalesMenuView();

		//ログイン認証
		login.checkin();

		//★タンク総量の設定
		int tank = 5000;

		//カウンタ変数の初期化
		Map<String, Object> sharedData = new HashMap<String, Object>();
		sharedData.put("counts", 0);
		sharedData.put("countt", 0);
		sharedData.put("countb", 0);
		sharedData.put("SUM", 0);
		sharedData.put("tank", tank);
		sharedData.put("id", login.id);
		sharedData.put("orderNo",0 );

		//商品の表示⇒購入数選択⇒お釣り計算		
		smv.execute(new HashMap<String, Object>(), new HashMap<String, Object>(), sharedData);

	}

}
