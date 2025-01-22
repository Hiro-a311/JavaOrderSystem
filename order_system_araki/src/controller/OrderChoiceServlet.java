package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dto.OrderhistoryDTO;
import dto.SeatDTO;
import dto.TempOrderDTO2;


/**
 * Servlet implementation class OrderChoiceServlet
 */
@WebServlet("/orderchoice")
public class OrderChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		// 要求を取得
		String command = request.getParameter("command");

		String nextPage = "";

		// command の値に応じて処理を振り分ける
		if (command.equals("menu")) {
			nextPage = menuService(request, response);
		} else if(command.equals("order")){
			nextPage = orderService(request, response);

		}

		// 処理結果によって指定のJSPに遷移させる
		request.getRequestDispatcher(nextPage).forward
											(request, response);
	}

	private String menuService(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {

		return "MenuTop.jsp";
	}
	private String orderService(HttpServletRequest request,
			HttpServletResponse response)
		throws ServletException, IOException {
		//履歴に書き込む
		HttpSession session = request.getSession();
		DBManager dbm = new DBManager();
		ArrayList<TempOrderDTO2> templist = (ArrayList<TempOrderDTO2>) session.getAttribute("templist");
		SeatDTO seat = (SeatDTO) session.getAttribute("seat");
		int seatId = seat.getSeatId();

		for(int i=0;i<templist.size();i++) {
			String goodsName = templist.get(i).getGoodsName();
			String goodsId = dbm.getGoodsId(goodsName);
			int orderNum = templist.get(i).getTempNum();
			int orderFlag = 0;
			/*
			System.out.println(i+ ":" +goodsId);
			System.out.println(i+ ":" +seatId);
			System.out.println(i+ ":" +orderNum);
			System.out.println(i+ ":" +orderFlag);
			*/
			OrderhistoryDTO history = new OrderhistoryDTO();
			history.setGoodsId(goodsId);;
			history.setOrderFlag(orderFlag);
			history.setOrderNum(orderNum);
			history.setSeatId(seatId);
			//System.out.println(history.getGoodsId());
			dbm.setWritingOrderHistory(history);
		}

		//仮注文から削除
		dbm.deleteTemp(seatId);

		return "menufinish.jsp";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
