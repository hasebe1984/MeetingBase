package jp.co.sys.stub;

import jp.co.sys.dao.RoomDao;

public class RoomUpdateStub {
	public static void main(String[] args) {
		boolean passingstatus = RoomDao.update("テスト");
		System.out.println(passingstatus);
	}
}