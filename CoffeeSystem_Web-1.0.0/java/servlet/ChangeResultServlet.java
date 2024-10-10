package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CalcService;
import service.CalcService;

/**
* Servlet implementation class InputMoneyServlet
*/
@WebServlet("/ChangeResultServlet")
public class ChangeResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッション開始
		HttpSession session = request.getSession(false);

		//処理成功フォワード先
		String url = "/jsp/ChangeResult.jsp";

		//インスタンスの生成
		CalcService calcservice = new CalcService();
		CalcService calcservice2 = new CalcService();

		//変数の宣言
		int pay = 0;//支払い額
		int money = 0;//会計額

		try {
			//会計額
			ArrayList<Integer> pricelist = (ArrayList<Integer>) session.getAttribute("pricelist");
			pay = Integer.parseInt(request.getParameter("pay"));
			money = 0;

			for (int i = 0; pricelist.size() > i; i++) {
				money += pricelist.get(i);
			}
			session.setAttribute("money", money);
		} catch (Exception e) {
			String errMSG = "入力が有効ではありません。半角数字を入力してください。";
			request.setAttribute("errMSG", errMSG);
			url = "/jsp/InputMoney.jsp";
		}

		//お釣り計算メソッド呼び出し		
		int change = calcservice2.change_calc(money, pay);
		boolean flag = calcservice2.checkinput(change);

		if (flag) {
			//金種計算メソッド呼び出し、金種ごとのお釣りの配列を返す。
			int[] moneycount = calcservice.moneytype(change);
			session.setAttribute("change", change);//お釣り
			session.setAttribute("moneycount", moneycount);//金種配列
		} else {
			String errMSG = "金額が不足しています。再度入力してください";
			request.setAttribute("errMSG", errMSG);
			url = "/jsp/InputMoney.jsp";
		}

		//フォワード
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
