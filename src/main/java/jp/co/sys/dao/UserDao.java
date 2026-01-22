package jp.co.sys.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

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
	public static UserBean certificate​(String id, String password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		UserBean attestation = new UserBean(id, password);
		UserBean user = null;
		String pass = attestation.getPassword();
		//パスワードをハッシュ化用アルゴリズムの設定です。
		PBEKeySpec spec = new PBEKeySpec(pass.toCharArray(), attestation.getHash(), attestation.getIterations(),
				attestation.getKeyLength());
		//"PBKDF2WithHmacSHA256"は、ハッシュ化用アルゴリズムの設定です。
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		//DB接続し、SQL実行。
		String sql = "select * from user where id = ? AND password=? ";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, Base64.getEncoder().encodeToString(hash)); //ハッシュ化したパスワードをString変換
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					password = rs.getString("password");
					id = rs.getString("id");
					String name = rs.getString("name");
					String address = rs.getString("address");
					int isAdmin = rs.getInt("isAdmin");
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
	public static boolean insert​(UserBean userbean) throws Exception {
		int ret = -1;
		UserBean cipher = new UserBean();
		String sql = "INSERT INTO user (id,password,name, address ,isDeleted, isAdmin) VALUES(?, ?, ?, ?, ?,?)";
		//パスワードをハッシュ化
		String password = userbean.getPassword();
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), cipher.getHash(), cipher.getIterations(),
				cipher.getKeyLength());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = skf.generateSecret(spec).getEncoded();

		try (Connection conn = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, userbean.getId());
			pstmt.setString(2, Base64.getEncoder().encodeToString(hash)); //ハッシュ化したパスワードをString変換
			pstmt.setString(3, userbean.getName());
			pstmt.setString(4, userbean.getAddress());
			pstmt.setInt(5, userbean.getIsDeleted());
			pstmt.setInt(6, userbean.getIsAdmin());
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
					int isAdmin = rs.getInt("isAdmin");
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
					int isAdmin = rs.getInt("isAdmin");
					int isDeleted = rs.getInt("isDeleted");
					UserBean ub = new UserBean(address, id, name, password, isAdmin, isDeleted);
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
					rs.getInt("isAdmin"));
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
	public static boolean update(UserBean userbean) throws NoSuchAlgorithmException, InvalidKeySpecException {
		int ret = -1;
		UserBean cipher = new UserBean();
		String sql = "UPDATE user SET name =?, address=?, password=?, isAdmin=? WHERE id=?";
		String password = userbean.getPassword();
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), cipher.getHash(), cipher.getIterations(),
				cipher.getKeyLength());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, userbean.getName());
			pstmt.setString(2, userbean.getAddress());
			pstmt.setString(3, Base64.getEncoder().encodeToString(hash));
			pstmt.setInt(4, userbean.getIsAdmin());
			pstmt.setString(5, userbean.getId());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

}
