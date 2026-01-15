package jp.co.sys.stub.ikeda;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.dao.RoomDao;

public class RoomFindIdStub {

	public static void main(String[] args) {
		RoomBean name = RoomDao.findId("0201");
		System.out.println(name);
		System.out.println(name.getClass().getName()); //変数のデータ型を確認する
	}
}
