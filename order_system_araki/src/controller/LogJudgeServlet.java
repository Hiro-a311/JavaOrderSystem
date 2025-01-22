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
import dto.MemberDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/judge")
public class LogJudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogJudgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String memberMail = request.getParameter("memberMail");
		String memberPw = request.getParameter("memberPw");

		RequestDispatcher dispatcher = null;
		String message = null;

		if(memberMail.equals("")||memberPw.equals("")) {
			message = "メールアドレスとパスワードは入力必須です";

			request.setAttribute("alert", message);

			dispatcher = request.getRequestDispatcher("logYes.jsp");
			dispatcher.forward(request, response);
		} else {
			DBManager dbm = new DBManager();
			MemberDTO member = dbm.getLoginUser(memberMail, memberPw);

			if(member != null) {
				HttpSession session = request.getSession();

				session.setAttribute("member", member);

				dispatcher = request.getRequestDispatcher("number.jsp");
			} else {
				message = "ログインIDまたはパスワードが違います";
				request.setAttribute("alert", message);

				dispatcher = request.getRequestDispatcher("logYes.jsp");
			}

			dispatcher.forward(request, response);
		}
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

}
