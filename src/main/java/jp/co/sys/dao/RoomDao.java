package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.util.DatabaseConnectionProvider;

/**
 * データベース「meetingroomb」のテーブル「room」を操作するクラスです。
 * @author 池田喜一郎
 * @version 1.0
 */
public class RoomDao{
	public static List<RoomBean> findAll() {
		List<RoomBean> roomlist = new ArrayList<>();
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
	/**
	 * @param name　会議室名
	 * @return　テーブル「room」へのデータ挿入真偽
	 */
	public static boolean insert(String name) {
		int ret = -1;
		String sql = "INSERT INTO room VALUES (?,?)";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setInt(1, 1111); //仮
			pstmt.setString(2, "仮会議室"); //仮
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

	/**
	 * @param name　会議室名
	 * @return　テーブル「room」のデータ「name」のデータ変更真偽
	 */
	public static boolean update(String name) {
		int ret = -1;
		String sql = "UPDATE room SET name =? WHERE id =?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, "変更できた会議室"); //仮
			pstmt.setInt(2, 1111); //仮
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

	/**
	 * @param id　会議室ID
	 * @return　テーブル「room」のデータ「id」のデータ削除真偽
	 */
	public static boolean delete(RoomBean deleteroom) {
		int ret = -1;
		String sql = "DELETE FROM room WHERE id=?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, deleteroom.getId()); //仮
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}
}