package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sys.bean.MeetingRoom;
import jp.co.sys.bean.ReservationBean;
import jp.co.sys.bean.RoomBean;

/**
 * Servlet implementation class CancelCreateServlet
 */
@WebServlet("/CancelCreateServlet")
public class CancelCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/**get通信の場合はログイン画面へリダイレクト */
		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/** セッション取得 */
		HttpSession session = request.getSession();
/** 入力された情報取得 */
		String roomId = request.getParameter("roomId");
		String time = request.getParameter("time");
/** 会議室管理システム取得 */		
		MeetingRoom meetingRoom=(MeetingRoom) session.getAttribute(roomId);
/** 取り消す予約 */
		ReservationBean reservation = meetingRoom.createReservation(roomId,start");			
				/** 取り消す予約（会議室ID、開始時間）をセッションにセットする */
		
		RoomBean room=(RoomBean)session.setAttribute("roomId", roomId);
		ReservationBean reservation=session.setAttribute("time", time);
/** 予約確認画面へフォワード */
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/cancelConfirm.jsp");
		rd.forward(request, response);
		//		response.sendRedirect(request.getContextPath() + "/jsp/cancelConfirm.jsp");
	}
}
	