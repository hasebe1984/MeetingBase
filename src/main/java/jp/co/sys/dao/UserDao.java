package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.UserBean;
import jp.co.sys.util.DatabaseConnectionProvider;
import jp.co.sys.util.UserList;

/**
 * ユーザ認証が出来たか出来てないかを｢MeetingRoom｣に返す
 * @author 加藤博文
 */
public class UserDao {
	/**
	 * 利用者IDとパスワードで利用者認証を行い，認証した利用者情報を返します。
	 * @param id
	 * @param password
	 * @return 
	 */
	public static UserBean certificate​(String id, String password) {
		UserBean user = null;
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
					String isAdmin = rs.getString("isAdmin");
					int isDeleted = rs.getInt("isDeleted");
					user = new UserBean(address, id, name, password, isAdmin, isDeleted);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;
	}

	/**
	 * ユーザを追加します
	 * @param userbean
	 * @return　ユーザテーブルにアカウント情報を追加
	 */
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
			pstmt.setString(6, userbean.getIsAdmin());
			//更新クエリの実行
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQLに関するエラーです。");
		}
		return ret != 0;
	}

	/**
	 * ユーザーに削除フラグ（論理削除）を実施します。
	 * @param id
	 * @return　isDeletedが出来たらtrueをisDeletedが出来なければfalseを返す
	 */
	public static boolean delete​(UserBean userbean) {
		String sql = "update user set isDeleted = 1 where id  = ?";
		//update user set isDeleted = '1' where id  = '2500001' ;
		// try-with-user構文でリソースを自動的にクローズ
		//		if (userbean.getDeleted() != 1) {
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

		}
		return false;
	}

	/**
	 * 引数idNowから始まるid検索
	 * @param idNow
	 * @return
	 */
	public static UserList getNowId(String idNow) {
		UserList userlist = new UserList();
		//SQL文user_idを指定して、レコードを取得
		String sql = "select * from user where id like ? ";
		//データベースへ接続
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			//受け取ったIdをSQL文へ代入
			pstmt.setString(1, idNow + "%");
			try (ResultSet rs = pstmt.executeQuery()) {

				//			SQL文を実行して実行結果を取
				while (rs.next()) {
					//実行結果よりそれぞれのカラムの値を取得
					String id = rs.getString("id");
					String address = rs.getString("address");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String isAdmin = rs.getString("isAdmin");
					int isDeleted = rs.getInt("isDeleted");
					UserBean ub = new UserBean(id, address, name, password, isAdmin, isDeleted);
					userlist.add(ub);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userlist;

	}

	/**
	 * 有効ユーザーをUserListで全件出力する
	 * @return
	 */
	public static UserList findAll() {
		UserList userlist = new UserList();
		//SQL文user_idを指定して、レコードを取得
		String sql = "select * from user where id AND isDeleted != 1";
		//データベースへ接続
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			//受け取ったIdをSQL文へ代入

			try (ResultSet rs = pstmt.executeQuery()) {

				//			SQL文を実行して実行結果を取
				while (rs.next()) {
					//実行結果よりそれぞれのカラムの値を取得
					String id = rs.getString("id");
					String address = rs.getString("address");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String isAdmin = rs.getString("isAdmin");
					int isDeleted = rs.getInt("isDeleted");
					UserBean ub = new UserBean(id, address, name, password, isAdmin, isDeleted);
					userlist.add(ub);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userlist;
	}

	/**
	 * 利用者IDで該当するユーザーを検索し、存在する場合UserBeanで返し、存在しないばあいnullを返す。
	 * @param id
	 * @return
	 */
	public static UserBean findById(String id) {
		String sql = "SELECT * FROM user WHERE id=?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			UserBean rb = new UserBean(
					rs.getString("id"),
					rs.getString("name"),
					rs.getString("address"),
					rs.getString("password"),
					rs.getString("isAdmin"));
			return rb;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param userbean
	 * @return
	 */
	public static boolean update(UserBean userbean) {
		int ret = -1;
		String sql = "UPDATE user SET name =?, address=?, password=?, isAdmin=? WHERE id=?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, userbean.getName());
			pstmt.setString(2, userbean.getAddress());
			pstmt.setString(3, userbean.getPassword());
			pstmt.setString(4, userbean.getIsAdmin());
			pstmt.setString(5, userbean.getId());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

}
