package jp.co.sys.stub.kato;

import java.util.List;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.bean.UserBean;

public class UserCertificate​Stub {
	public static void main(String[] args) {
		List<UserBean> list = new UserBean("東京都", "2500001","一般太郎","111111");
		System.out.println(list);
		for (RoomBean room : list) {
			System.out.println(room.getId());
			System.out.println(room.getName());
		}
	}
}