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

import DTO.Product;
import service.CalcService;
import service.CalcService;
import service.ProductDAO;

/**
* Servlet implementation class CalcItemServlet
*/
@WebServlet("/CalcItemServlet")
public class CalcItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// セッション開始
		HttpSession session = request.getSession(true);

		// フォワード先
		String url = "/jsp/InputMoney.jsp";

		// インスタンス生成
		CalcService calcService = new CalcService();
		CalcService calcService2 = new CalcService();
		ProductDAO pdao = new ProductDAO();

		// 商品リスト呼び出し
		ArrayList<Product> productlist = pdao.selectAll();

		// 注文数パラメータの取得
		String Small = request.getParameter("s_order");
		String Tall = request.getParameter("t_order");
		String Big = request.getParameter("b_order");

		String[] buy_order = { Small, Tall, Big };

		// 商品ごとの会計
		ArrayList<Integer> pricelist = calcService2.Calc(buy_order);

		// 商品ごとの通算購入数
		ArrayList<Integer> totalorderlist = (ArrayList<Integer>) session.getAttribute("totalorderlist");

		if (totalorderlist == null) {
			totalorderlist = new ArrayList<>();
			for (String Buy_order : buy_order) {
				totalorderlist.add(Integer.parseInt(Buy_order));
			}
		} else {
			for (int i = 0; i < buy_order.length; i++) {
				int orderCount = Integer.parseInt(buy_order[i]);
				if (i < totalorderlist.size()) {
					totalorderlist.set(i, totalorderlist.get(i) + orderCount);
				} else {
					totalorderlist.add(orderCount);
				}
			}
		}

		// Scope格納
		session.setAttribute("totalorderlist", totalorderlist); // 商品ごとの通算購入個数
		session.setAttribute("buy_order", buy_order); // 買った数の配列
		session.setAttribute("productlist", productlist); // 商品インスタンス配列
		session.setAttribute("pricelist", pricelist); // 商品ごとの会計

		// フォワード
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
