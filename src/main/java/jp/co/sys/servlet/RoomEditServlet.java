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
		request.setAttribute("title", title);
				
		String roomName = request.getParameter("roomName");
		String roomFloor = request.getParameter("roomFloor");
		
		if ("決定".equals(action)) {
	
			nextPage = "/jsp/conferenceRoomConfirm.jsp";
			
		}
		
		if ("登録".equals(action)) {


			roomFloor = request.getParameter("roomFloor");
			nextPage = "/jsp/conferenceRoomed.jsp";
			
		}
		
		RoomBean room = new RoomBean(roomFloor, roomName);
		
		request.setAttribute("room", room);
		

		request.getRequestDispatcher(nextPage).forward(request, response);
	
	}

}
