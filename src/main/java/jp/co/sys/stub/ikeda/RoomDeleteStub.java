package jp.co.sys.stub.ikeda;

import java.util.List;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.dao.RoomDao;

public class RoomDeleteStub {
	public static void main(String[] args) {
		List<RoomBean> rb = RoomDao.findAll();
		RoomBean piyo = new RoomBean("1111", "変更できた会議室");
		boolean passingstatus = RoomDao.delete(piyo);
		System.out.println(passingstatus);
		System.out.println(rb);
	}
}
