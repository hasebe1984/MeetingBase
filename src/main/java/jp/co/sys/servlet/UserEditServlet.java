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
 * 会員情報の編集を制御するサーブレットです。
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserEditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MeetingRoom mr = (MeetingRoom)session.getAttribute("meetingRoom");
		
		String action = request.getParameter("action");
		
		String userAddress = request.getParameter("userAddress");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		String userAdmin = request.getParameter("userAdmin");
		String checked = "on".equals(userAdmin) ? "checked" : null;
		userAdmin = "on".equals(userAdmin) ? "管理者" : "一般会員";
		
		UserBean user = new UserBean(userAddress, userId, userName, userPw, userAdmin);
		
		String nextPage = "/jsp/editInput.jsp";			
		String message = "";
		
//		入力後の画面遷移
		if ("会員情報編集".equals(action)) {
//			nextPage = "/jsp/editInput.jsp";
			user = mr.getUser();
			
		} else if ("編集".equals(action)) {
//			nextPage = "/jsp/editInput.jsp";
			user = mr.getUser();
			
		}
		else if ("決定".equals(action)) {
			nextPage = "/jsp/edittedConfirm.jsp";
			
		} else if ("戻る".equals(action)) {
			nextPage = "/jsp/editInput.jsp";
			
		} else if ("登録".equals(action)) {
			Boolean isSuccess = false; 
			try {
				isSuccess = mr.editUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			成功
			if (isSuccess) {
				nextPage = "/jsp/editted.jsp";
				mr.getUsers();
				
//			失敗
			} else {
				nextPage = "/jsp/edittedError.jsp";
				message = "エラーメッセージ";
				
			}
		}
		
		request.setAttribute("user", user);
		request.setAttribute("checked", checked);
		request.setAttribute("message", message);

		request.getRequestDispatcher(nextPage).forward(request, response);
		
	}

}
