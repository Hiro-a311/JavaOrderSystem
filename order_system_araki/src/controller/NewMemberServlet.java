package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import dto.MemberDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/newMem")
public class NewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBManager dbm;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");

		// 要求を取得
		String command = request.getParameter("command");

		String nextPage = "";

		// command の値に応じて処理を振り分ける
		if (command.equals("logNew")) {
			nextPage = logNew(request, response);
		} else if(command.equals("logNewCheck")){
			nextPage = logNewCheck(request, response);
		} else if(command.equals("return")){
			nextPage = "logNew.jsp";
		} else if(command.equals("logNewReturn")){
			nextPage = "login.jsp";
		}

		request.getRequestDispatcher(nextPage).forward(request, response);

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	private String logNew(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
    	String memberMail = request.getParameter("memberMail");
		String memberPw = request.getParameter("memberPw");
		String memberPwCheck = request.getParameter("memberPwCheck");
		String memberName = request.getParameter("memberName");

		String message = null;

		if(memberMail.equals("")||memberPw.equals("")||memberPwCheck.equals("")||memberName.equals("")) {
			message = "名前とメールアドレスとパスワードは入力必須です";

			request.setAttribute("alert", message);

			return "logNew.jsp";
		} else if (!memberMail.contains("@")) {
	        message = "メールアドレスの形式が違います。@は必須です";
	        request.setAttribute("alert", message);

	        return "logNew.jsp";
	    } else if (!(memberPw.equals(memberPwCheck))) {
	        message = "パスワードが確認用と一致しません";
	        request.setAttribute("alert", message);

	        return "logNew.jsp";
	    } else {
			request.setAttribute("memberMail", memberMail);
			request.setAttribute("memberPw", memberPw);
			request.setAttribute("memberName", memberName);

			return "logNewCheck.jsp";
		}
	}

	private String logNewCheck(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		if(dbm == null){
			dbm = new DBManager();
		}
		MemberDTO member = new MemberDTO();

    	String memberMail = request.getParameter("memberMail");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberId = "";

		String str;

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

			memberId = formatNowDate + str;
		}while(dbm.checkMemberId(memberId));

		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		member.setMemberMail(memberMail);

		dbm.setWritingMember(member);

		return "logYes.jsp";
	}

}
