package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.util.DatabaseConnectionProvider;

public class RoomDao {
	private RoomDao() {
	}

	public static RoomBean[] findAll() {
		RoomBean[] room = new RoomBean();
		String sql = "SELECT * FROM reservation";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String room1 = rs.getString("id");
				String currentUser = rs.getString("name");
				System.out.println("接続先DB：" + room);
				System.out.println("ログインユーザー：" + currentUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	追加・削除・編集のメソッド　名前は仮で

}