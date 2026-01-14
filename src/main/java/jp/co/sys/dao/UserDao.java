package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.UserBean;
import jp.co.sys.util.DatabaseConnectionProvider;

public class UserDao {

	private UserDao() {
	}

	//	利用者IdとPasswordの認証を行う

	/**
	 * 利用者IDとパスワードで利用者認証を行い，認証した利用者情報を返します。
	 * @param id
	 * @param password
	 * @return
	 */
	public static UserBean certificate​(String id, String password) {
		UserBean user = new UserBean();
		//SQL文user_idを指定して、レコードを取得
		String sql = "select * from user where id = ? AND password=? ";
		//データベースへ接続
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			//受け取ったIdをSQL文へ代入
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {

				//			SQL文を実行して実行結果を取
				while (rs.next()) {
					//実行結果よりそれぞれのカラムの値を取得
					password = rs.getString("password");
					id = rs.getString("id");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String isAdmin = rs.getString("admin");
					String isDeleted = rs.getString("deleted");
					//		String address, String id, String name, String password
					//					user = new UserBean(address, id, name, password, isDeleted, isAdmin);
					user = new UserBean(address, id, name, password,isAdmin,isDeleted);
					return user;
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	//	ユーザを追加します
	public static boolean insert​(UserBean userbean) {
		int ret = -1;
		String sql = "INSERT INTO user (id,password,name, address ,isDeleted, isAdmin) VALUES(?, ?, ?, ?, ?,?)";
		// INSERT INTO user (id,password,name, address , isDeleted, isAdmin) VALUES ("null", "111111", "一般太郎", "東京都", "0","0");
		// try-with-resources構文でリソースを自動的にクローズ
		try (Connection conn = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// プレースホルダーに値を設定
			pstmt.setString(1, userbean.getId());
			pstmt.setString(2, userbean.getPassword());
			pstmt.setString(3, userbean.getName());
			pstmt.setString(4, userbean.getAddress());
			pstmt.setString(5, userbean.getDeleted());
			pstmt.setString(6, userbean.getAdmin());
			//更新クエリの実行
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		return ret != 0;
	}

	//	予約を削除します
	public static boolean delete​(UserBean userbean) {
		String sql = "update user set isDeleted = 1 where id  = ?";
		//update user set isDeleted = '1' where id  = '2500001' ;
		// try-with-user構文でリソースを自動的にクローズ
		//		if(userbean.getDeleted()!= 1) {
		try (Connection conn = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// プレースホルダーに値を設定
			pstmt.setString(1, userbean.getId());
			//更新クエリの実行
			int ret = pstmt.executeUpdate();
			return ret != 0;

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
			//		}else {
			//			return null;

			//		}
		}
		return false;
	}
}
