package system;

import java.util.Scanner;

//ログイン認証
public class Login {

	//★id,passの設定
	public String id = "id";
	public String pass = "pass";

	public void checkin() {

		int frag = 0;
		Scanner scan = new Scanner(System.in);

		while (frag == 0) {
			System.out.println("IDとパスワードを入力してください");
			System.out.print("ID：");
			String inputid = scan.nextLine();
			System.out.print("パスワード：");
			String inputpass = scan.nextLine();

			if (inputid.equals(id) && inputpass.equals(pass)) {
				frag = 1;
				System.out.println("【認証されました】");
				System.out.println("");

			} else {
				System.out.println("【ID、もしくはパスワードが間違っています】");
				System.out.println("");
			}
		}
	}
}