package jp.co.sys.stub.kato;

import java.util.List;

import jp.co.sys.bean.UserBean;
import jp.co.sys.dao.UserDao;

public class UserDeleteStub {

	public static void main(String[] args) {
		UserBean hoge =new UserBean("愛知県", "2600000", "池田", "222222", "1", "0");
		boolean passingstatus = UserDao.delete​(hoge);
		System.out.println(passingstatus);
		List<UserBean> aaa = UserDao.certificate​(hoge);
		System.out.println(aaa);
	}
}