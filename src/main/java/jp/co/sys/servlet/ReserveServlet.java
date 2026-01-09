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
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストで取得した文字をUTF-8へ
		request.setCharacterEncoding("UTF-8");

		//sessionの取得
		HttpSession session = request.getSession();

		//会議室管理システムの取得
		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingroom");

		//DBに記録する予約のデータの取得
		ReservationBean reservation = (ReservationBean) session.getAttribute("reservation");

		try {

			//meetingroomに予約確定の依頼↓//外す
			
			meetingRoom.reserve​("reservation");

			//登録成功したら予約完了画面へ
			request.getRequestDispatcher("/jsp/reserved.jsp")
					.forward(request, response);

		} catch (Exception e) {
			
			//予約できなかった理由
			
			
			//登録失敗したらエラーメッセージを保持して予約エラー画面へ
			request.getRequestDispatcher("/jsp/reserveError.jsp" + e.getMessage())
					.forward(request, response);
		}
	}

}
