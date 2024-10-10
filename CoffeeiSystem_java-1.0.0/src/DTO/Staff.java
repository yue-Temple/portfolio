package DTO;

import java.io.Serializable;

public class Staff implements Serializable {

	//フィールドの定義
	private String id;//ユーザーID
	private String pass;//パスワード

	//アクセサメソッドの定義
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
