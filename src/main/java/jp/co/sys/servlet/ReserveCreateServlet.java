package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sys.bean.MeetingRoom;
import jp.co.sys.bean.ReservationBean;

/**
 * Servlet implementation class reserveCreateServlet
 */
@WebServlet("/reserveCreateServlet")
public class ReserveCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
		// URLから直接アクセスした場合はログイン画面へ
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
			return;
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストで取得した文字をUTF-8へ
		 	request.setCharacterEncoding("UTF-8");
		 	
		//リクエストパラメータの取得
			String roomId = request.getParameter("roomId");//会議室ID
			String start = request.getParameter("time");//利用開始時刻
			
		//sessionの取得
			HttpSession session =request.getSession();
			
		//sessionからmeetingRoomを取得
			MeetingRoom meetingroom =(MeetingRoom)session.getAttribute("meetingroom");
			
		//Meetingroomに予約情報の生成を依頼する
			ReservationBean reservation = meetingroom.createResevation("roomId,start");			
			
		//sessionに戻す
			session.setAttribute("reservation", reservation);
		
		//元の画面に戻る
		    request.getRequestDispatcher("/jsp/reserveConfirm.jsp")
			.forward(request, response);
				
	}

}
