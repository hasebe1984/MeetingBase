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
	//	static UserBean	 certificate​(java.lang.String id,java.lang.String password) {

	public static UserBean certificate​(java.lang.String id, java.lang.String password) {
		UserBean user= new UserBean();
		//SQL文user_idを指定して、レコードを取得
		String sql = "select * from user where id = ?";
		//データベースへ接続
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
		//受け取ったIdをSQL文へ代入
			pstmt.setString(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				//			SQL文を実行して実行結果を取
				while (rs.next()) {
					//実行結果よりそれぞれのカラムの値を取得
					password = rs.getString("password");
					id = rs.getString("id");
					user=;
				}
			}
			}catch (ClassNotFoundException e) {
				return null;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;
		}
}




