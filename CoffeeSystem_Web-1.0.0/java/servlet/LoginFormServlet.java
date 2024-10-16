package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet("/LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/jsp/LoginForm.jsp";
		
		request.setCharacterEncoding("UTF-8");
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
