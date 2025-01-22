package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dto.MemberDTO;
import dto.SeatDTO;

/**
 * Servlet implementation class SeatInfoServlet
 */
@WebServlet("/seat")
public class SeatInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBManager dbm;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String nextPage = "";

		// command の値に応じて処理を振り分ける
		if (command.equals("number")) {
			nextPage = number(request, response);
		} else if(command.equals("numberCheck")){
			nextPage = numberCheck(request, response);
		} else if(command.equals("numberCheckReturn")){
			nextPage = "number.jsp";
		}

		request.getRequestDispatcher(nextPage).forward(request, response);
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

	private String number(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		if(dbm == null){
			dbm = new DBManager();
		}

		String alcohoNum = request.getParameter("alcohoNum");
		String nonAlcohoNum = request.getParameter("nonAlcohoNum");
		String seatId = request.getParameter("seatId");

		SeatDTO checkSeat = new SeatDTO();
		checkSeat = dbm.checkSeat(Integer.parseInt(seatId));

		String jsp = "";
		String message = null;

		if(!(checkSeat.getMemberId().equals("0"))&&
				!(checkSeat.getAlcoholNum()==0)&&
				!(checkSeat.getTotalNum()==0)) {
			message = "その席はすでに人がいます。";
			request.setAttribute("alert", message);
			jsp = "number.jsp";
		} else if(alcohoNum.equals("")||nonAlcohoNum.equals("")) {
			message = "人数は入力必須です";

			request.setAttribute("alert", message);
			jsp = "number.jsp";
		} else if(alcohoNum.equals("0")&&nonAlcohoNum.equals("0")) {
			message = "人数は入力必須です";

			request.setAttribute("alert", message);
			jsp = "number.jsp";
		} else {
			request.setAttribute("alcohoNum", alcohoNum);
			request.setAttribute("nonAlcohoNum", nonAlcohoNum);
			request.setAttribute("seatId", seatId);
			jsp = "numberCheck.jsp";
		}

		return jsp;
	}

	private String numberCheck(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		if(dbm == null){
			dbm = new DBManager();
		}
		HttpSession session = request.getSession();
		MemberDTO member = new MemberDTO();
		SeatDTO seat = new SeatDTO();

		String jsp;

		String memberId;
		String seatIdS = request.getParameter("seatId");
		String alcohoNumS = request.getParameter("alcohoNum");
		String nonAlcohoNumS = request.getParameter("nonAlcohoNum");

		int seatId = Integer.parseInt(seatIdS);
		int alcohoNum = Integer.parseInt(alcohoNumS);
		int nonAlcohoNum = Integer.parseInt(nonAlcohoNumS);

		member = (MemberDTO) session.getAttribute("member");

		String str;

		if(member!=null) {
			memberId = member.getMemberId();
		} else {
			do {

				int num = (int) (Math.random()*1000);
				Integer i = Integer.valueOf(num);
				if(i<10) {
					str = i.toString();
					str = "00" + str;
				} else if (i<100) {
					str = i.toString();
					str = "0" + str;
				} else {
					str = i.toString();
				}

				LocalDateTime nowDate = LocalDateTime.now();
				DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				String formatNowDate = dtf3.format(nowDate);

				memberId = "0_" + formatNowDate + str;
			}while(dbm.checkGuestId(memberId));
		}

		seat.setSeatId(seatId);
		seat.setTotalNum(alcohoNum + nonAlcohoNum);
		seat.setAlcoholNum(alcohoNum);
		seat.setMemberId(memberId);

		session.setAttribute("seat", seat);
		jsp = "menu.jsp";
		dbm.setWritingSeat(seat);

		return jsp;
	}

}
