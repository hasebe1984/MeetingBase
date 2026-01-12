package jp.co.sys.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jp.co.sys.dao.RoomDao;
import jp.co.sys.dao.UserDao;

public class MeetingRoom implements Serializable {
	//フィールド
	private static final long serialVersionUID = 1L;
	private static int INTERVAL = 60;
	private static String[] PERIOD = {"09:00", "10:00", "11:00", "12:00","13:00", "14:00", "15:00", "16:00"};
	private String date;
	private RoomBean[] rooms;
	private UserBean user;
	
	//コンストラクタ
	public MeetingRoom() {
		this.rooms = RoomDao.findAll();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.date =currentDate.format(dateTimeFormatter); 
	}
	
	//メソッド
	public ReservationBean createReservation​(String roomId, String start) {
		LocalTime startTime = LocalTime.parse(start);
		LocalTime endTime = startTime.plusMinutes(INTERVAL);
		String end = endTime.toString();
		String userId = user.getId();//ここわからなさすぎるて
		ReservationBean reservation = new ReservationBean(roomId, date, start, end, userId);
		return reservation;
	}
	public String getDate() {
		return date;
	}
	public void	setDate​(String date) {
		this.date = date;
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
		for(RoomBean room:rooms) {
			if(room.getId().equals(roomId)) {
				return room;
			}
		}
		return null;
	}
	public RoomBean[] getRooms() {
		return rooms;
	}
	public UserBean	getUser() {
		return user;
	}
	public boolean login​(String id, String password) {
		UserBean result = UserDao.certificate​(id,password);
		if(result != null) {
			this.user = result;
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
