package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;

/**
 * Servlet implementation class LoginResultServlet
 */
@WebServlet("/LoginResultServlet")
public class LoginResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);

		String url = "/jsp/SalesMenu.jsp";
		request.setCharacterEncoding("UTF-8");

		String inputID = request.getParameter("id");
		String inputPASS = request.getParameter("pass");
		LoginService ls = new LoginService();
		boolean flag = ls.loginSystem(inputID, inputPASS);
	
		
		if (flag) {
			request.setAttribute("outMsg", "認証されました");
			String staffid = ls.getstaffid(inputID);
			session.setAttribute("staffid", staffid);
		} else {
			request.setAttribute("outMsg", "IDまたはパスワードが違います");
			url = "/jsp/ErrPage.jsp";
		}

		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
