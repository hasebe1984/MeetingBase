package jp.co.sys.stub;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.dao.RoomDao;

public class RoomListStub {
	public static void main(String[] args) {
		RoomBean[] list = RoomDao.findAll();
		for (RoomBean room : list) {
            System.out.println(room.getId());
            System.out.println(room.getName());
        }
	}
}