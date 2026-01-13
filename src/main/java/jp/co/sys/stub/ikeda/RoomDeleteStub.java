package jp.co.sys.stub.ikeda;

import jp.co.sys.dao.RoomDao;

public class RoomDeleteStub {
	public static void main(String[] args) {
		boolean passingstatus = RoomDao.delete(1111);
		System.out.println(passingstatus);
	}
}