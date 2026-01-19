package jp.co.sys.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String address;
	private String id;
	private String name;
	private String password;
	private String isAdmin;
	private String isDeleted;
	private String userId;

	public UserBean() {
	}
//	① public setId(userId) 、②public UserBean(String address, String name, String password, String isAdmin)

//	使ってない
//	public UserBean(String address, String name, String password, String isAdmin) {
//		super();
//		this.address = address;
//		this.name = name;
//		this.password = password;
//		this.isAdmin= isAdmin;
//	}
	
	public UserBean(String address, String id, String name, String password, String isAdmin) {
		super();
		this.address = address;
		this.id = id;
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
	}
//		UserDao
//		UserEditServlet
//		RegistrationServlet
	public UserBean(String address, String id, String name, String password, String isAdmin, String isDeleted) {
		super();
		this.address = address;
		this.id = id;
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isDeleted = isDeleted;
	}
//		UserDao
	public UserBean(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public String getIsDeleted() {
		return isDeleted;
	}
	public String getuserId(){
		return userId;
	}
	public void setId(String userId) {
		this.userId=userId;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + password + " 管理者フラグ:" + isAdmin + " " + address + "　削除フラグ：" + isDeleted + "\n";
	}
}
