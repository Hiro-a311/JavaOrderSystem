package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dto.TempOrderDTO2;

/**
 * Servlet implementation class TempOrderCreateServlet
 */
@WebServlet("/tempOrderCreate")
public class TempOrderCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempOrderCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String command = request.getParameter("command");

		DBManager dbManager = new DBManager();
		List<TempOrderDTO2> tempOrderList = dbManager.getTempOrderList();

		TempOrderDTO2 to = new TempOrderDTO2();
		 	HttpSession session = request.getSession();
		 	session.setAttribute("goodsList", goodsList);
		 	RequestDispatcher dispatcher = request.getRequestDispatcher("MenuTop.jsp");
	        dispatcher.forward(request, response);


	}

}
