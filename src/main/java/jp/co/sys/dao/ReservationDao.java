package jp.co.sys.dao;

import java.util.ArrayList;
import java.util.List;

import jp.co.sys.bean.ReservationBean;

public class ReservationDao {
	private ReservationDao() {
	}

//	利用日の予約を検索します
	public static java.util.List<ReservationBean> findByDate​(java.lang.String date){
		List<ReservationBean> rlist = new ArrayList<>();
	    String sql = "SELECT * FROM word WHERE  word1 = ?";

		
	}
	
	
//	予約を追加します
	public static boolean insert​(ReservationBean reservation) {
		
	}
	
//	予約を削除します
	public static boolean delete​(ReservationBean reservation) {
		
	}
}
