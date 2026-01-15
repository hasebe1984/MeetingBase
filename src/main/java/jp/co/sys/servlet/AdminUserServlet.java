package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sys.stub.hasebe.UserDao;
//import jp.co.sys.dao.UserDao;
import jp.co.sys.util.UserList;

/**
 * 会員の一覧表示および削除を制御するサーブレットです。
 */
@WebServlet("/AdminUserServlet")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserServlet() {
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
		
		String action = request.getParameter("action");
		String nextPath = "/jsp/userList.jsp";
		
		UserList list = null;
		try {
			list = UserDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String message = "";
		
		if ("削除".equals(action)) {
			Boolean isSuccess = false;
			
			if(isSuccess) {
				message = "削除しました。";
			} else {
				message = "削除できませんでした。";
			}
		}
		
		request.setAttribute("message", message);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher(nextPath).forward(request, response);
	}

}
