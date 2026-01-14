package jp.co.sys.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String address;
	private String id;
	private String name;
	private String password;
	private String admin;
	private String deleted;

	public UserBean() {
	}

	public UserBean(String address, String id, String name, String password) {
		super();
		this.address = address;
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public UserBean(String address, String id, String name, String password, String admin, String deleted) {
		super();
		this.address = address;
		this.id = id;
		this.name = name;
		this.password = password;
		this.admin = admin;
		this.deleted = deleted;
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

	public String getAdmin() {
		return admin;
	}

	public String getDeleted() {
		return deleted;
	}

	@Override
	public String toString() {
		return address + id + password+  name;
	}
}
