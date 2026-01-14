package jp.co.sys.stub.koyama;

import jp.co.sys.bean.ReservationBean;
import jp.co.sys.util.ReservationList;

public class test {

	public static void main(String[] args) {

		//		List<ReservationBean> rb = ReservationDao.findByDate​("2026-01-01");
		//		System.out.println(rb);

		//		ReservationBean hoge = new ReservationBean("0302", "2026-01-10", "09:00:00", "10:00:00", "2500003");
		//		boolean in = ReservationDao.insert​(hoge);
		//		System.out.println(in);
		//
		//		ReservationBean huga = new ReservationBean("0302", "2026-01-10", "09:00:00", "10:00:00", "2500003");
		//		boolean dl = ReservationDao.delete​(huga);
		//		System.out.println(dl);

		//		ReservationList fa = ReservationDao.findAll();
		//		System.out.println(fa);

		
		ReservationBean huga = new ReservationBean("0302", "2026-01-10", "09:00:00", "10:00:00", "2500003");
		ReservationList fc = huga.findByDate(huga);
		System.out.println(fa);

	}
}
