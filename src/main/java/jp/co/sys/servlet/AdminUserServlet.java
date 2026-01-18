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
		
		String userAddress = request.getParameter("userAddress");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		String userAdmin = request.getParameter("userAdmin");
		UserBean user = new UserBean(userAddress, userId, userName, userPw, userAdmin);
		
		String action = request.getParameter("action");
		String nextPath = "/jsp/userList.jsp";
		
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
		UserList list = mr.getUsers();
		
		request.setAttribute("message", message);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher(nextPath).forward(request, response);
	}

}
