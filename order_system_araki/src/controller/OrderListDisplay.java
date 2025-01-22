package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dto.SeatDTO;
import dto.TempOrderDTO;
import dto.TempOrderDTO2;


/**
 * Servlet implementation class OrderListDisplay
 */
@WebServlet("/orderlistdisplay")
public class OrderListDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		DBManager dbm = new DBManager();
		RequestDispatcher dispatcher = null;
		//String seatIdS = request.getParameter("seatId");
		//int seatId = Integer.parseInt(seatIdS);
		SeatDTO seat = (SeatDTO) session.getAttribute("seat");
		int seatId = seat.getSeatId();

		// ユーザ情報を取得できたら、書き込み内容リストを取得
		ArrayList<TempOrderDTO> templist = dbm.getInfoTemporder(seatId);

		ArrayList<TempOrderDTO2> templist2 = new ArrayList<>();

		for(int i=0;i<templist.size();i++) {
			String goodsId = templist.get(i).getGoodsId();
			String goodsName = dbm.getGoodsName(goodsId);
			int goodsPrice = dbm.getGoodsPrice(goodsId);
			int tempNum = templist.get(i).getTempNum();
			TempOrderDTO2 temp = new TempOrderDTO2(goodsPrice, goodsName, tempNum);
			System.out.println(goodsName);
			templist2.add(temp);
		}

		// ログインユーザ情報、書き込み内容リストとしてセッションに保存
		session.setAttribute("templist", templist2);

		// 処理の転送先を top.jsp に指定
		dispatcher = request.getRequestDispatcher("menuConfirm.jsp");

	// 処理を転送
		dispatcher.forward(request, response);
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
		doGet(request, response);
	}

}
