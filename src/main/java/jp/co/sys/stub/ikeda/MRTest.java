package jp.co.sys.stub.ikeda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.util.DatabaseConnectionProvider;
import jp.co.sys.util.RoomList;

public class MRTest {

	public static void main(String[] args) {
		RoomList roomlist = new RoomList();
		String sql = "SELECT * FROM room";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String roomid = rs.getString("id");
				String roomname = rs.getString("name");
				RoomBean rb = new RoomBean(roomid, roomname);
				roomlist.add(rb);
				System.out.println(rb);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}