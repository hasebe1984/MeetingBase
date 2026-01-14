package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sys.bean.ReservationBean;
//テスト終わったら変える
import jp.co.sys.stub.asano.MeetingRoom;

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
		MeetingRoom meetingRoom = (MeetingRoom) session.getAttribute("meetingRoom");

		
		try {
			//DBに記録する予約情報のデータの取得
			ReservationBean reservation = (ReservationBean) session.getAttribute("reservation");
			
			//reservation:予約情報が nullかチェック
            if (reservation == null) {
                throw new Exception("reservation が session に存在しません");
            }
			
         // ===== コンソール確認用 =====
            System.out.println("=== 予約登録内容 ===");
            System.out.println("日付: " + reservation.getDate());
            System.out.println("部屋ID: " + reservation.getRoomId());
            System.out.println("開始: " + reservation.getStart());
            System.out.println("終了: " + reservation.getEnd());
            System.out.println("ユーザー: testUser" );  
            System.out.println("isDeleted:"+ reservation.getIsDeleted());
            System.out.println("===================");
            
            //本来ここでmeetingroomに予約確定の依頼↓//外す
			
			//meetingRoom.reserve​("reservation");
            
            //登録に成功したらtrueを表示
            session.setAttribute("reserved", true);
            System.out.println("登録可否: "+ session.getAttribute("reserved"));
            
            //完了画面へ
			request.getRequestDispatcher("/jsp/reserved.jsp")
					.forward(request, response);

		} catch (Exception e) {
			
			//予約できなかった理由
			
			
			//登録失敗したら予約エラー画面へ
			request.getRequestDispatcher("/jsp/reserveError.jsp")
					.forward(request, response);
		}
	}

}
