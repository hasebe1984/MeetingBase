package jp.co.sys.stub.ikeda;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.dao.RoomDao;

public class RoomFindIdStub {

	public static void main(String[] args) {
		RoomBean piyo = new RoomBean("0201");
		String name = RoomDao.findId(piyo);
		System.out.println(name);
		System.out.println(name.getClass().getName()); //変数のデータ型を確認する
	}
}
