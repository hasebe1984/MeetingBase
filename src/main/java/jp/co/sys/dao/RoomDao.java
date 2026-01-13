package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.util.DatabaseConnectionProvider;
import jp.co.sys.util.RoomList;

/**
 * データベース「meetingroomb」のテーブル「room」を操作するクラスです。
 * @author 池田喜一郎
 */
public class RoomDao {
	/**
	 * @return RoomList型の全テーブルデータを返す。データがない場合は、nullを返す。
	 */
	public static RoomList findAll() {
		RoomList roomlist = new RoomList();
		String sql = "SELECT * FROM room";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
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
	 * @param insertroom　登録するデータ
	 * @return テーブル「room」へのデータ挿入真偽
	 */
	public static boolean insert(RoomBean insertroom) {
		int ret = -1;
		String sql = "INSERT INTO room VALUES (?,?)";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, insertroom.getId());
			pstmt.setString(2, insertroom.getName());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

	/**
	 * @param updateroom　修正するデータ
	 * @return テーブル「room」のデータ「name」のデータ変更真偽
	 */
	public static boolean update(RoomBean updateroom) {
		int ret = -1;
		String sql = "UPDATE room SET name =? WHERE id =?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, updateroom.getName());
			pstmt.setString(2, updateroom.getId());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

	/**
	 * @param deleteroom　削除するデータ
	 * @return テーブル「room」のデータ「id」のデータ削除真偽
	 */
	public static boolean delete(RoomBean deleteroom) {
		int ret = -1;
		String sql = "DELETE FROM room WHERE id=?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, deleteroom.getId());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}
}