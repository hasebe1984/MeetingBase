package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sys.dao.RoomDao;
import jp.co.sys.util.RoomList;

/**
 * 会議室の一覧表示および削除を制御するサーブレットです。
 */
@WebServlet("/RoomAdminServlet")
public class RoomAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoomAdminServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String nextPath = "/jsp/conferenceRoomList.jsp";
		
		RoomList list = null;
		try {
			list = RoomDao.findAll();
			
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