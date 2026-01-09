package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.ReservationBean;
import jp.co.sys.util.DatabaseConnectionProvider;

public class ReservationDao {
	private ReservationDao() {
	}

	//	利用日の予約を検索します
	public static java.util.List<ReservationBean> findByDate​(java.lang.String date) {
		ReservationBean rb = new ReservationBean();
		String sql = "SELECT * FROM reservation WHERE  date = ?";

		try (Connection conn = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// プレースホルダに日付をセット
			pstmt.setString(1, date);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ReservationBean rb = new ReservationBean();
					// 値の取得
					int id = rs.getInt("id");
					String roomId = rs.getString("roomId");
					date = rs.getString("date");
					String start = rs.getString("start");
					String end = rs.getString("end");
					String userID = rs.getString("userID");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rb;
	}

	//	予約を追加します
	public static boolean insert​(ReservationBean reservation) {
		String sql = "INSERT INTO dictionary (engword, jpword) VALUES(?, ?)";
		// try-with-resources構文でリソースを自動的にクローズ
		try (Connection conn = DictionaryConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// プレースホルダーに値を設定
			pstmt.setString(1, dict.getEnglish());
			pstmt.setString(2, dict.getJapanese());
			//更新クエリの実行
			int ret = pstmt.executeUpdate();
			return ret != 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("ドライバが見つかりません。");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}

		return false;

	}

	//	予約を削除します
	public static boolean delete​(ReservationBean reservation) {
		return false;

	}
}
