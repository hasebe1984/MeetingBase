package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sys.bean.ReservationBean;
import jp.co.sys.util.DatabaseConnectionProvider;

public class ReservationDao {
	private ReservationDao() {
	}

	//	利用日の予約を検索します
	public static List<ReservationBean> findByDate​(String date) {
		List<ReservationBean> list = new ArrayList<>();
		String sql = "SELECT id, roomId, date, start, end,userID FROM reservation WHERE date = ? and isDeleted = 0";

		try (Connection conn = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// プレースホルダに日付をセット
			pstmt.setString(1, date);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					// 値の取得
					//					int id = rs.getInt("id");
					//					String roomId = rs.getString("roomId");
					//					String date2 = rs.getString("date");
					//					String start = rs.getString("start");
					//					String end = rs.getString("end");
					//					String userID = rs.getString("userID");
					//					ReservationBean rb = new ReservationBean(id, roomId, date2, start, end, userID);
					ReservationBean rb = new ReservationBean(rs.getInt("id"), rs.getString("roomId"),
							rs.getString("date"),
							rs.getString("start"), rs.getString("end"), rs.getString("userID"));
					list.add(rb);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//	    // 空だったらnullを入れる
		//	    if (list.isEmpty()) {
		//	        return null;
		//	    }

		return list;
	}

	//	予約を追加します
	public static boolean insert​(ReservationBean reservation) {
		String sql = "INSERT INTO reservation (roomId,date,start,end,userID) VALUES(?, ?, ?, ?, ?)";
		//INSERT INTO reservation (roomId, date, start, end, userID) VALUES ("0302", "2026-01-10", "09:00:00", "10:00:00", "2500003");
		// try-with-resources構文でリソースを自動的にクローズ
		try (Connection conn = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// プレースホルダーに値を設定
			pstmt.setString(1, reservation.getRoomId());
			pstmt.setString(2, reservation.getDate());
			pstmt.setString(3, reservation.getStart());
			pstmt.setString(4, reservation.getEnd());
			pstmt.setString(5, reservation.getUserID());
			//更新クエリの実行
			int ret = pstmt.executeUpdate();
			return ret != 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		return false;
	}

	//	予約を削除します
	public static boolean delete​(ReservationBean reservation) {
		String sql = "update reservation set isDeleted = 1 where roomId = ? and date = ? and start = ? and isDeleted = 0";
		//update reservation set isDeleted = 1 where roomId = "0302" and date = "2026-01-10" and start = "09:00:00 and isDeleted = 0";
		// try-with-resources構文でリソースを自動的にクローズ
		try (Connection conn = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// プレースホルダーに値を設定
			pstmt.setString(1, reservation.getRoomId());
			pstmt.setString(2, reservation.getDate());
			pstmt.setString(3, reservation.getStart());
			//更新クエリの実行
			int ret = pstmt.executeUpdate();
			return ret != 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		return false;
	}
}
