package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sys.util.MeetingRoom;

/**
 * Servlet implementation class ChangeDateServlet
 */
@WebServlet("/ChangeDateServlet")
public class ChangeDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		String date = request.getParameter("date");
		String page = request.getParameter("page");
		
		//sessionの取得
		HttpSession session =request.getSession();
		
		//会議室管理システム取得
		MeetingRoom meetingroom =(MeetingRoom)session.getAttribute(page);
		
		//利用日更新
		//
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
