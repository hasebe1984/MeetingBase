package jp.co.sys.stub.ikeda;

import java.util.List;

import jp.co.sys.bean.UserBean;

public class UserTest {

	public static void main(String[] args) {
		UserBean hoge = new UserBean("2500001", "111111");
		List<UserBean> piyo = UserBean.certificate​(hoge);
		System.out.println(piyo);
	}
}