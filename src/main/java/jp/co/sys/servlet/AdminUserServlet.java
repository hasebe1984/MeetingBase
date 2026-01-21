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
import jp.co.sys.util.UserList;

/**
 * 会員の一覧表示および削除を制御するサーブレットです。
 */
@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminUserServlet() {
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
//		String userId = request.getParameter("userId");
		String userId = "会員情報編集".equals(action) ? mr.getUser().getId() : request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		String userAdmin = request.getParameter("userAdmin");
		
		String checked = "on".equals(userAdmin) ? "checked" : "";
		userAdmin = "on".equals(userAdmin) ? "管理者" : "一般会員";
		int userAdminInt = "管理者".equals(userAdmin) ? 1 : 0;
		
		UserBean user = new UserBean(userAddress, userId, userName, userPw, userAdminInt);
		
		String nextPath = "/jsp/userList.jsp";
		String cancelFlag = request.getParameter("cancelFlag");
		String adminFlag = request.getParameter("adminFlag");
		
//		会議室の削除
		String message = "";
		
		if ("削除".equals(action)) {
			Boolean isSuccess = false;
			
			try {
				isSuccess = mr.deleteUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(isSuccess) {
				message = "削除しました。";
				mr.getUsers();

			} else {
				message = "削除できませんでした。";
			}
		}
		if ("退会する".equals(action)) {
			Boolean isSuccess = false;
			
			try {
				isSuccess = mr.deleteUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(isSuccess) {
				message = "退会しました。";
				nextPath = "/jsp/login.jsp";
				mr.getUsers();
				
			} else {
				message = "退会できませんでした。";
				nextPath = "/jsp/editInput.jsp";
				
			}
		}
		
		UserList list = mr.getUsers();
		
		request.setAttribute("message", message);
		request.setAttribute("list", list);
		request.setAttribute("user", user);
		request.setAttribute("checked", checked);
		request.setAttribute("cancelFlag", cancelFlag);
		request.setAttribute("adminFlag", adminFlag);
		
		request.getRequestDispatcher(nextPath).forward(request, response);
	}

}
