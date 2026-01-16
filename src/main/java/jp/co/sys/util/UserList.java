package jp.co.sys.util;

import java.util.ArrayList;

import jp.co.sys.bean.UserBean;

public class UserList extends ArrayList<UserBean> {
	private static final long serialVersionUID = 1L;
	private String idNow;

	public UserList() {
	}

	public UserList(String idNow) {
		super();
		this.idNow = idNow;
	}

	public String getIdNow() {
		return idNow;
	}

}
