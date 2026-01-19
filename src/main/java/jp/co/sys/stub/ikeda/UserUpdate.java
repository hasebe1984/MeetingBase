package jp.co.sys.stub.ikeda;

import jp.co.sys.bean.UserBean;
import jp.co.sys.dao.UserDao;
import jp.co.sys.util.UserList;

public class UserUpdate {

	public static void main(String[] args) {
		UserBean piyo = new UserBean("なんとか県", "2500003", "修正さん", "222222", "0");
		boolean passingstatus = UserDao.update(piyo);
		System.out.println(passingstatus);
		UserList rb = UserDao.findAll();
		System.out.println(rb);
	}
}
