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
		int cancelFlag =  mr.getUser().getIsAdmin();
//		int cancelFlag = request.getParameter("cancelFlag");
		String adminFlag = request.getParameter("adminFlag");
		String transition = request.getParameter("transition");
		
		if ("会員情報編集".equals(action)) {
			userAddress = mr.getUser().getAddress();
			userId = mr.getUser().getId();
			userName = mr.getUser().getName();
			userPw = "";
			userAdminInt = mr.getUser().getIsAdmin();
			checked = userAdminInt == 1 ? "checked" : "";
			
			user = new UserBean(userAddress, userId, userName, userPw, userAdminInt);
			
			transition = "会員情報編集";
			
//		} else if ("編集".equals(action) || mr.getUser().getIsAdmin() == 1) {
		} else if ("編集".equals(action)) {
			checked = userAdminInt == 1 ? "checked" : "";
			adminFlag = "1";
			transition = "編集";
		}
		
		
		if ("決定".equals(action)) {
			
			if (userPw.length() > 10 || userPw.length() < 6 || !userPw.matches("^[a-zA-Z0-9]+$")) {
				message += "パスワードは、6文字から10文字の半角英数字のみ、";
			} 
			if (userName.length() > 10) {
				message += "氏名は10文字以内、";
			}
			if (userAddress.length() > 30) {
				message += "住所は30文字以内、";
			}
			if (userName.matches(".*[<>'\"&; 　].*") || userAddress.matches(".*[<>'\"&; 　].*") ) {
				message += "半角記号・スペースを使用しない形式、";
			}

			if (message != "") {
				message += "で入力してください。";
				request.setAttribute("user", user);
				request.setAttribute("checked", checked);
				request.setAttribute("message", message);
				request.setAttribute("cancelFlag", cancelFlag);
//				request.setAttribute("adminFlag", adminFlag);
				request.setAttribute("transition", transition);
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
				
				String errorMessage = e.getMessage();
				
				if("存在しないユーザーです".equals(errorMessage)) {
					message = "存在しないユーザーです。";
					
				} else if("削除されたユーザーです".equals(errorMessage)) {
					message = "削除されたユーザーです。";
					
					
				} else if("変更できないユーザーです。".equals(errorMessage)) {
					message = "変更できないユーザーです。";
				
				} else {
					message = "変更できませんでした。";

				}
				
			}
			
//			成功
			if (isSuccess) {
				mr.getUsers();
				nextPage = "/jsp/editted.jsp";
				
//			失敗
			} else {
				nextPage = "/jsp/edittedError.jsp";
				
			}

		} else if ("メニューへ".equals(action)) {
			nextPage = "/jsp/menu.jsp";
			
		} else if ("一覧へ".equals(action)) {
			nextPage ="AdminUserServlet";
		}
		
		
		request.setAttribute("user", user);
		request.setAttribute("checked", checked);
		request.setAttribute("message", message);
		request.setAttribute("cancelFlag", cancelFlag);
		request.setAttribute("adminFlag", adminFlag);
		request.setAttribute("transition", transition);

		request.getRequestDispatcher(nextPage).forward(request, response);
		
	}

}
