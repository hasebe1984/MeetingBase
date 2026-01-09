package jp.co.sys.bean;

import java.io.Serializable;

import jp.co.sys.dao.RoomDao;
import jp.co.sys.dao.UserDao;

public class MeetingRoom implements Serializable {
	//フィールド
	private static final long serialVersionUID = 1L;
	private static int INTERVAL = 60;
	private static String[] PERIOD;
	private String date;
	private RoomBean[] rooms;
	private UserBean user;
	
	//コンストラクタ
	public MeetingRoom() {}
	
	//メソッド
	public ReservationBean createReservation​(String roomId, String start) {
		return ;
	}
	public String getDate() {
		return ;
	}
	public void	setDate​(String date) {
		
	}
	public static String[] getPeriod() {
		return ;
	}
	private int startPeriod​(String start) throws IndexOutOfBoundsException {
		return ;
	}
	public ReservationBean[][] getReservations(){
		return;
	}
	public RoomBean	getRoom​(String roomId) {
		return ;
	}
	public RoomBean[] getRooms() {
		return RoomDao.findAll();
	}
	public UserBean	getUser() {
		return user;
	}
	public boolean login​(String id, String password) {
		user = UserDao.certificate​(id,password);
		if(user != null) {
			return true;
		} else {
			return false;
		}
	}
	private int	roomIndex​(String roomId) throws IndexOutOfBoundsException {
		
		return ;
	}
	public void	reserve​(ReservationBean reservation) throws Exception {
		
	}
	public void cancel​(ReservationBean reservation) throws Exception {
		
	}
	
	public String toString() {
		return;
	}
}
