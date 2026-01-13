package jp.co.sys.stub.ikeda;

import java.util.List;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.dao.RoomDao;

public class RoomListStub {
	public static void main(String[] args) {
		List<RoomBean> list = RoomDao.findAll();
		System.out.println(list);
		for (RoomBean room : list) {
            System.out.println(room.getId());
            System.out.println(room.getName());
        }
	}
}