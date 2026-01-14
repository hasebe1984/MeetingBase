package jp.co.sys.stub.ikeda;

import java.util.List;

import jp.co.sys.bean.UserBean;
import jp.co.sys.dao.UserDao;

public class Aaaaa {

	public static void main(String[] args) {
		UserBean rb = new UserBean("東京都", "2500001","一般太郎","111111");
		List<UserBean> aaa = UserDao.certificate​(rb);
		System.out.println(aaa);
	}
}
