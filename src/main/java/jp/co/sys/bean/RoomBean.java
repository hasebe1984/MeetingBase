package jp.co.sys.bean;

import java.io.Serializable;

/**
 * RoomBeanを定義するクラスです。
 * @author 池田喜一郎
 */
public class RoomBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	/**
	 * デフォルトコンストラクタです。
	 */
	public RoomBean() {
		super();
	}

	/**
	 * 会議室検索用のコンストラクタです。
	 * @param id roomテーブルのカラム「id」です。
	 * @param name roomテーブルのカラム「name」です。
	 */
	public RoomBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * 会議室登録用のコンストラクタです。
	 * @param name roomテーブルのカラム「id」です。
	 */
	public RoomBean(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + " " + name + "\n";
	}
}