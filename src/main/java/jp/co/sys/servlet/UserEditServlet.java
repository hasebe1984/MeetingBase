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
		String checked = "on".equals(userAdmin) ? "checked" : "";		
		userAdmin = "on".equals(userAdmin) ? "管理者" : "一般会員";
		int userAdminInt = "管理者".equals(userAdmin) ? 1 : 0;

		UserBean user = new UserBean(userAddress, userId, userName, userPw, userAdminInt);
		
		String nextPage = "/jsp/editInput.jsp";			
		String message = "";
		String cancelFlag = request.getParameter("cancelFlag");
		String adminFlag = request.getParameter("adminFlag");
		
		if ("会員情報編集".equals(action)) {
			userAddress = mr.getUser().getAddress();
			userId = mr.getUser().getId();
			userName = mr.getUser().getName();
			userPw = mr.getUser().getPassword();
			userAdminInt = mr.getUser().getIsAdmin();
			checked = userAdminInt == 1 ? "checked" : "";
			cancelFlag = "1";
			
			user = new UserBean(userAddress, userId, userName, userPw, userAdminInt);
			
		}
		 if ("編集".equals(action) || mr.getUser().getIsAdmin() == 1) {
			checked = userAdminInt == 1 ? "checked" : "";
			adminFlag = "1";
		 }
		
		
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
				message = "変更に失敗しました。";
				
			}
		}
		
		request.setAttribute("user", user);
		request.setAttribute("checked", checked);
		request.setAttribute("message", message);
		request.setAttribute("cancelFlag", cancelFlag);
		request.setAttribute("adminFlag", adminFlag);

		request.getRequestDispatcher(nextPage).forward(request, response);
		
	}

}
