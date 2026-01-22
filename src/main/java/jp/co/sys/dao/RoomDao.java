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
	 * 引数なしで、予約データを取得するメソッドです。
	 * @return RoomList型の全テーブルデータを返す。データがない場合は、nullを返す。
	 */
	public static RoomList findAll() {
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
			}
			return roomlist;
		} catch (SQLException e) {
			System.out.println("★findAllのRoomDAOでエラー発生！");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 会議室IDを引数に、当該会議室IDでの予約データを取得するメソッドです。
	 * @param id 会議室ID
	 * @return RoomBean型のデータを返す。データがない場合は、nullを返す。
	 */
	public static RoomBean findId(String id) {
		String sql = "SELECT * FROM room WHERE id=?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			RoomBean rb = new RoomBean(rs.getString("id"), rs.getString("name"));
			return rb;
		} catch (SQLException e) {
			System.out.println("★findIdのRoomDAOでエラー発生！");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 会議室の階数にて、会議室IDの最新データを取得するメソッドです。
	 * @param idFloor 会議室の階数
	 * @return RoomBean型のデータを返す。データがない場合は、nullを返す。
	 */
	public static RoomBean getFloorId(String idFloor) {
		//SQL文user_idを指定して、レコードを取得
		String sql = "SELECT * FROM room WHERE id LIKE ? ORDER BY id DESC LIMIT 1";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, idFloor + "%");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			RoomBean rb = new RoomBean(rs.getString("id"), rs.getString("name"));
			return rb;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 新規で会議室IDと、会議室名を登録するメソッドです。
	 * @param insertroom　登録するデータをRoomBean型で取得する。
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
	 * 既存のテーブルデータを会議室IDから取得し、会議室名を修正するメソッドです。
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
	 * 既存のテーブルデータを会議室IDから取得し、会議室データを物理削除するメソッドです。
	 * @param deleteroom　削除するデータ
	 * @return テーブル「room」のデータ「id」のデータ削除真偽
	 */
	public static boolean delete(RoomBean deleteroom) {
		int ret = -1;
		String sql = "DELETE FROM room WHERE id=?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, deleteroom.getId().trim());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}
}