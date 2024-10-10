package DTO;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	
	//フィールドの定義
	private int onebuy;//注文個数
	private Product product;//商品
	
	//コンストラクタ
	public OrderDetail(int onebuy, Product product) {
		super();
		this.onebuy = onebuy;
		this.product = product;
	}
	
	//アクセサメソッド
	public int getOnebuy() {
		return onebuy;
	}
	public void setOnebuy(int onebuy) {
		this.onebuy = onebuy;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
