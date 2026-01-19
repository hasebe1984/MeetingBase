package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sys.bean.MeetingRoom;
import jp.co.sys.bean.UserBean;

/**
 * 会員の新規登録を制御するサーブレットです。
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MeetingRoom mr = (MeetingRoom)session.getAttribute("meetingRoom");
		
		String action = request.getParameter("action");
		
		String userAddress = request.getParameter("userAddress");
		String userId = "登録ボタン押したとき、生成・取得";
//		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		String userAdmin = request.getParameter("userAdmin");
		String checked = "on".equals(userAdmin) ? "checked" : null;
		userAdmin = "on".equals(userAdmin) ? "管理者" : "一般会員";
		
		
		UserBean user = new UserBean(userAddress, userId, userName, userPw, userAdmin);
		
		String nextPage = "jsp/registrationInput.jsp";
		String message = "";


		
		
		if ("決定".equals(action)) {
			
			if (userPw.length() > 10 || userPw.length() < 6) {
				message += "パスワードは、6文字から10文字で入力してください。";
				

			} 
			
			if (userName.length() > 10) {
				message += "氏名は10文字以内で入力してください。";
				
			}
			if (userAddress.length() > 30) {
				message += "住所は30文字以内で入力してください。";
				
			}
			
			if (message != "") {
				request.setAttribute("user", user);
				request.setAttribute("checked", checked);
				request.setAttribute("message", message);
				request.getRequestDispatcher(nextPage).forward(request, response);
				return;
			}
			nextPage = "jsp/registrationConfirm.jsp";
			
		} else if ("戻る".equals(action)) {
			nextPage = "jsp/registrationInput.jsp";
			
		}  else if ("登録".equals(action)) {
			Boolean isSuccess = false; 
			try {
//				成功判定のメソッド考える
				isSuccess = mr.addUser(user);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			成功
			if (isSuccess) {
//				mr.addUser(user);
				nextPage = "/jsp/registered.jsp";
				mr.getUsers();
				
//			失敗
			} else {
				nextPage = "/jsp/registrationError.jsp";
				message = "エラーメッセージ";
				
			}
		}

		request.setAttribute("user", user);
		request.setAttribute("checked", checked);
		request.setAttribute("message", message);
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
