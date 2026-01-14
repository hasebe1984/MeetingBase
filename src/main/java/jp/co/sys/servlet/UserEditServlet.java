package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sys.bean.UserBean;

/**
 * 会員情報の編集を制御するサーブレットです。
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userAddress = request.getParameter("userAddress");
		String userAdmin = request.getParameter("userAdmin");
		String checked = "on".equals(userAdmin) ? "checked" : null;
		userAdmin = "on".equals(userAdmin) ? "管理者" : "一般会員";
		
		String action = request.getParameter("action");

		String nextPage = "jsp/edittedConfirm.jsp";
		
//		UserBean user = new UserBean(userAddress, session.userId, userName, userPw, userAdmin);
		UserBean user = new UserBean(userAddress, "id", userName, userPw, userAdmin);
		request.setAttribute("user", user);
		request.setAttribute("checked", checked);
		
		
		
		if ("決定".equals(action)) {
			
//			if (UserDao.registration(user)) {
//				nextPage = "jsp/registered.jsp";
//				
//			} else {
//				nextPage = "jsp/registrationError.jsp";
//				
//			}
			nextPage = "jsp/editted.jsp";
			
		} else if ("戻る".equals(action)) {
			nextPage = "jsp/editInput.jsp";
			
		}

		request.getRequestDispatcher(nextPage).forward(request, response);
		
	}

}
