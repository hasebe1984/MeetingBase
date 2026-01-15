package jp.co.sys.stub.hasebe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.UserBean;
import jp.co.sys.util.DatabaseConnectionProvider;
import jp.co.sys.util.UserList;

public class UserDao {

	public static UserList findAll() {
		UserList list = new UserList();
		String sql = "SELECT * FROM user";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String userAddress = rs.getString("address");
				String userId = rs.getString("id");
				String userName = rs.getString("name");
				String userPassword = rs.getString("password");
				String userAdmin = rs.getString("admin");
				UserBean ub = new UserBean(userAddress, userId, userName, userPassword, userAdmin, "0");
				list.add(ub);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
