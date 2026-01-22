package jp.co.sys.bean;

import java.io.Serializable;

/**
 * UserBeanを定義する為のクラスです。
 * @author 加藤博文
 * @param pepper ハッシュ化用のペッパーデータの定数です。
 * @param hash ペッパーデータをbyte[]変換する用の定数データです。
 * @param iterations ハッシュ化を繰り返す回数を定義する定数です。
 * @param keyLength 出力bitを定義する定数です。（256bit＝32バイト）
 */
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String password;
	private String address;
	private int isAdmin;
	private int isDeleted;
	private final String pepper = "NKkxGDiVF9i+V7m5Ww70YA==";
	private final byte[] hash = pepper.getBytes();
	private final int iterations = 65536;
	private final int keyLength = 256;

	public UserBean() {
	}

	/**
	 * @param id userテーブルのテーブルのカラム「id」です。
	 * @param name userテーブルのテーブルのカラム「name」です。
	 * @param password userテーブルのテーブルのカラム「password」です。
	 * @param address userテーブルのテーブルのカラム「address」です。
	 * @param isAdmin userテーブルのテーブルのカラム「isAdmin」です。
	 */
	public UserBean(String address, String id, String name, String password, int isAdmin) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.isAdmin = isAdmin;
	}

	/**
	 * @param id userテーブルのテーブルのカラム「id」です。
	 * @param name userテーブルのテーブルのカラム「name」です。
	 * @param password userテーブルのテーブルのカラム「password」です。
	 * @param address userテーブルのテーブルのカラム「address」です。
	 * @param isAdmin userテーブルのテーブルのカラム「isAdmin」です。
	 * @param isDeleted userテーブルのテーブルのカラム「isDeleted」です。
	 */
	public UserBean(String address, String id, String name, String password, int isAdmin, int isDeleted) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.isAdmin = isAdmin;
		this.isDeleted = isDeleted;
	}
	
	/**
	 * @param id userテーブルのテーブルのカラム「id」です。
	 * @param password userテーブルのテーブルのカラム「password」です。
	 */
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
