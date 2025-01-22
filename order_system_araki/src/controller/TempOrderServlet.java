package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import dto.TempOrderDTO;

/**
 * Servlet implementation class TempOrderServlet
 */
@WebServlet("/tempOrder")
public class TempOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TempOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		response.getWriter().append("Served at: ").append(request.getContextPath());

		//JSPからcommand(パラメータ)を受ける
		String command = request.getParameter("command");

		//TempOrderDTO型のtempOrderListを定義
		DBManager dbManager = new DBManager();
		List<TempOrderDTO> tempOrderList = dbManager.getTempOrderList();

		//リクエストスコープにtempOrderListを登録
		 request.setAttribute("tempOrderList",tempOrderList);

		 //MenuTop画面に遷移
		 RequestDispatcher dispatcher = request.getRequestDispatcher("MenuTop.jsp");
		 dispatcher.forward(request, response);
	}
}
