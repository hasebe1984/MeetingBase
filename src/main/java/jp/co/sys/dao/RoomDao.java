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

	public static RoomBean findAll() {
		RoomBean roomlist = new RoomBean();
		String sql = "SELECT * FROM room";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String roomid = rs.getString("id");
				String roomname = rs.getString("name");
				RoomBean rb = new RoomBean(roomid, roomname);
				roomlist.add(rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomlist;
	}

	//	追加・削除・編集のメソッド　名前は仮で
	public static boolean insert(String name) {
		int ret = -1;
		String sql = "INSERT INTO room VALUES (?,?)";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setInt(1, 111111); //仮
			pstmt.setString(2, "仮会議室"); //仮
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

	//	public int update(String name, String id) {
	//		String sql = "UPDATE room SET name =? WHERE id =?";
	//		return executeSql(sql);
	//	}
	//
	//	public int delete(String id) {
	//		String sql = "DELETE FROM room WHERE id=?";
	//		return executeSql(sql);
	//	}

	//	public int executeSql(String sql) {
	//		Statement stmt = null;
	//		ResultSet rs = null;
	//		int result = 0;
	//		try {
	//			connect();
	//			//②ステートメントを生成
	//			stmt = con.createStatement();
	//			//③SQLを実行
	//			result = stmt.executeUpdate(sql);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		} finally {
	//			try {
	//				if (rs != null)
	//					rs.close();
	//				if (stmt != null)
	//					stmt.close();
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//		disconnect();
	//		return result;
	//	}
	//
	//	public void disconnect() {
	//		try {
	//			//⑤DBを切断
	//			if (con != null)
	//				con.close();
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}
}