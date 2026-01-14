package jp.co.sys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sys.dao.RoomDao;

/**
 * 会議室の一覧表示および削除を制御するサーブレットです。
 */
@WebServlet("/RoomAdminServlet")
public class RoomAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RoomAdminServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** セッション取得 */
		HttpSession session = request.getSession();
		/** 入力された情報取得 */
		String roomid=request.getParameter("roomid");

	RoomDao.findAll();
	}
}