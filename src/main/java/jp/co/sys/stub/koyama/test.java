package jp.co.sys.stub.koyama;

import java.util.List;

import jp.co.sys.bean.ReservationBean;
import jp.co.sys.dao.ReservationDao;

public class test {

	public static void main(String[] args) {
		List<ReservationBean> rb = ReservationDao.findByDate​("2026-01-01");
		ReservationBean hoge = new ReservationBean(7, "0302", "2026-01-10", "09:00:00", "10:00:00", "2500003", 0);
		boolean in = ReservationDao.insert​(hoge);
		//		boolean dl= ReservationDao.delete​(ReservationBean reservation);

	}

}
