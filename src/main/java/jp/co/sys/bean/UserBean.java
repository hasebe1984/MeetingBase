package jp.co.sys.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String address;
	private String id;
	private String name;
	private String password;
	private int isAdmin;
	private int isDeleted;
	/**
	 * ハッシュ化用の定数準備
	 */
	private final String pepper = "NKkxGDiVF9i+V7m5Ww70YA==";
	private final byte[] hash = pepper.getBytes();
	private final int iterations = 65536;
	private final int keyLength = 256;

	public UserBean() {
	}

	public UserBean(String address, String id, String name, String password, int isAdmin) {
		super();
		this.address = address;
		this.id = id;
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public UserBean(String address, String id, String name, String password, int isAdmin, int isDeleted) {
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

	public int getIsAdmin() {
		return isAdmin;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public byte[] getHash() {
		return hash;
	}

	public int getIterations() {
		return iterations;
	}

	public int getKeyLength() {
		return keyLength;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + password + " 管理者フラグ:" + isAdmin + " " + address + "　削除フラグ：" + isDeleted + "\n";
	}
}
