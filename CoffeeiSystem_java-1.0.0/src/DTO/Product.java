package DTO;

import java.io.Serializable;

public class Product implements Serializable {

	//フィールドの定義
	private String itemid;//商品ID
	private String name;//商品名
	private int price;//値段
	private int tank;//容量

	//コンストラクタ
	public Product(String itemid, String name, int price, int tank) {
		super();
		this.itemid = itemid;
		this.name = name;
		this.price = price;
		this.tank = tank;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTank() {
		return tank;
	}

	public void setTank(int tank) {
		this.tank = tank;
	}

}
