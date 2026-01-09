package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.util.DatabaseConnectionProvider;

public class RoomDao {
	private RoomDao() {
	}

	public static RoomBean findAll() {
		List<RoomBean> roomlist = new ArrayList<>();
//		RoomBean room = new RoomBean();
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
	public int insert(int no, String name, int score) {
		String sql = "INSERT INTO student VALUES ("
				+ no + ", '" + name + "', " + score + ")";
		return executeSql(sql);
	}

	public int update(int no, String name, int score) {
		String sql = "UPDATE student SET no = " + no + ", name = '" + name
				+ "', score = " + score + " WHERE no = " + no;
		return executeSql(sql);
	}

	public int delete(int no) {
		String sql = "DELETE FROM student WHERE no = " + no;
		return executeSql(sql);
	}

	public int executeSql(String sql) {
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			connect();
			//②ステートメントを生成
			stmt = con.createStatement();
			//③SQLを実行
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return result;
	}

	public void disconnect() {
		try {
			//⑤DBを切断
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}