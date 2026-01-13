package jp.co.sys.stub.ikeda;

import jp.co.sys.dao.RoomDao;

public class RoomInsertStub {
	public static void main(String[] args) {
		boolean passingstatus = RoomDao.insert("テスト");
		System.out.println(passingstatus);
	}
}