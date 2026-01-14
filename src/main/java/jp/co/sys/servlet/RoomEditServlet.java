package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sys.bean.RoomBean;

/**
 * 会議室の登録および編集を制御するサーブレットです。
 */
@WebServlet("/RoomEditServlet")
public class RoomEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoomEditServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String roomNameDefault = "roomDAOでＩＤから取得";
		String roomFloorDefault = "一覧からＩＤを取得";
		RoomBean roomDefault = new RoomBean(roomFloorDefault, roomNameDefault);
		
		String action = request.getParameter("action");
		String nextPage = "";
		String title = request.getParameter("title");
		
		if ("編集".equals(action)) {
			title = "会議室編集";
			nextPage = "/jsp/conferenceRoomInput.jsp";
			
		} else if ("追加".equals(action)) {
			title = "会議室登録";
			nextPage = "/jsp/conferenceRoomInput.jsp";
			
		}
		
		String roomName = request.getParameter("roomName");
		String roomFloor = request.getParameter("roomFloor");
		RoomBean room = new RoomBean(roomFloor, roomName);
				
		if ("決定".equals(action)) {
			nextPage = "/jsp/conferenceRoomConfirm.jsp";	
			
		} else if ("戻る".equals(action)) {
			nextPage = "/jsp/conferenceRoomInput.jsp";
			
		} else if ("登録".equals(action)) {
			Boolean isSuccess = false;
			
			if("会議室編集".equals(title)) {
//				isSuccess = RoomDao.update(room);
				isSuccess = true;
				
			} else if ("会議室登録".equals(title)) {
//				isSuccess = RoomDao.insert(room);
				isSuccess = true;
				
			}
			
			if (isSuccess) {
				nextPage = "/jsp/conferenceRoomed.jsp";
				
			} else {
				nextPage = "/jsp/conferenceRoomError.jsp";	
			
			}
		}
		
		request.setAttribute("room", room);
		request.setAttribute("roomDefault", roomDefault);
		request.setAttribute("title", title);

		request.getRequestDispatcher(nextPage).forward(request, response);
	
	}

}
