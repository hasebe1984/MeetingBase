package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//	 直接URLを叩かれた場合はログイン画面へ戻す
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// コンテキストパスを含めてリダイレクト
		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
	}

	// JSPのフォームから送信された時の処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPw");
		String nextPage;
		//        ミーティングルームのメソッドを呼び込む

		//		  MeetingRoom meetingroom=new MeetingRoom();
		//        ユーザ情報がヌルじゃないか？
		//        	if(meetingroom.getUser()!= null) {
		//        	メニューJSPにページを飛ばす
		//        nextPage=request.getContextPath()+"jsp/menu.jsp";
		nextPage = request.getContextPath() + "/jsp/menu.jsp";
		//        	セッションを行う
		HttpSession session = request.getSession();
		session.setAttribute("pass", pass);
		session.setAttribute("id", id);
		//        	}else {
		//        		ログインJSPに飛ばす
		//       	nextPage=request.getContextPath()+"/jsp/login.jsp";
		//			}
		//        	ページ先に情報を渡す
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
	}
}
