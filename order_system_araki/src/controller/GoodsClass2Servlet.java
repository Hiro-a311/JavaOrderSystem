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
import dto.GoodsDTO;

/**
 * Servlet implementation class GoodsClass1Servlet
 */
@WebServlet("/goodsClass2")
public class GoodsClass2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsClass2Servlet() {
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

		//パラメータ取っているか確認(テスト)
		//String command = request.getParameter("command");
		//System.out.println(command);

		//JSPからcommand(パラメータ)を受ける
		String command = request.getParameter("command");

		//GoodsDTO型のgoodsListを定義
		DBManager dbManager = new DBManager();
        List<GoodsDTO> alcoholList = dbManager.getAlcoholList();

        //リクエストスコープにgoodsListを登録
        request.setAttribute("alcoholList", alcoholList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("MenuAlcohol.jsp");
        dispatcher.forward(request, response);

	}

}
