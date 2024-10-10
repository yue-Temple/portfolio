package system;

//タンク更新処理
public class TankCalc {
	
	//★内容量の設定
	int smallcup = 120;
	int tourcup = 220;
	int bigcup = 300;
	
	
	public int amountcalc(int _tank, int _buys, int _buyt, int _buyb){
		
		//タンク更新(スモール120ml トール220ml ビッグ300ml)
		int tank = _tank -(smallcup * _buys) - (tourcup * _buyt) - (bigcup * _buyb);
		//タンク容量チェック
		if(tank < 0) {
			System.out.println("タンク容量が無くなったため、タンクに不足分(" + (-tank) + "ml)+1000mlを追加します。");
			System.out.println("");
			tank += (-tank) + 1000;
		}
		return tank;
	}
	
	public int  alltank(int counts, int countt, int countb){
		int allcofee = smallcup * counts + tourcup * countt + bigcup * countb;
		return allcofee;
		
	}

}
