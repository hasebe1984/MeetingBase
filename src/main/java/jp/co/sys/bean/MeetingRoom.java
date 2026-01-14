package jp.co.sys.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jp.co.sys.dao.ReservationDao;
import jp.co.sys.dao.RoomDao;
import jp.co.sys.dao.UserDao;
import jp.co.sys.util.RoomList;

public class MeetingRoom implements Serializable {
	//フィールド
	private static final long serialVersionUID = 1L;
	private static int INTERVAL = 60;
	private static String[] PERIOD = {"09:00", "10:00", "11:00", "12:00","13:00", "14:00", "15:00", "16:00"};
	private String date;
	private RoomList rooms;
	private UserBean user;
	
	//コンストラクタ
	public MeetingRoom() {
		this.rooms = RoomDao.findAll();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.date =currentDate.format(dateTimeFormatter); 
	}
	
	//メソッド
	public String getDate() {
		return date;
	}
	public void	setDate​(String date) {
		this.date = date;
	}
	public RoomList getRooms() {
		return rooms;
	}
	public UserBean	getUser() {
		return user;
	}
	public static String[] getPeriod() {
		return PERIOD;
	}
	public RoomBean	getRoom​(String roomId) {
		for(RoomBean room:rooms) {
			if(room.getId().equals(roomId)) {
				return room;
			}
		}
		return null;
	}
	@SuppressWarnings("unlikely-arg-type")
	private int	roomIndex​(String roomId) throws IndexOutOfBoundsException {
		if (rooms.contains(roomId)) {
			int roomIndexNum = rooms.indexOf(roomId);
		return roomIndexNum;
		}
		throw new IndexOutOfBoundsException();
	}
	private int startPeriod​(String start) throws IndexOutOfBoundsException {
		int periodIndex = 0;
		for (int i=0;i<PERIOD.length;i++) {
			if(PERIOD[i].equals(start)) {
				periodIndex = i;
				return periodIndex;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	public ReservationBean[][] getReservations(){
		int roomSize = rooms.size();
		ReservationBean reservations[][] = new ReservationBean [roomSize][7];
		List<ReservationBean> reserveList = ReservationDao.findByDate​(date);
		for(ReservationBean reserve:reserveList) {
			int roomInd = roomIndex​(reserve.getRoomId());
			int startInd = startPeriod​(reserve.getStart());
			reservations[roomInd][startInd] = reserve;
		}
		return reservations;
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
	public ReservationBean createReservation​(String roomId, String start) {
		LocalTime startTime = LocalTime.parse(start);
		LocalTime endTime = startTime.plusMinutes(INTERVAL);
		String end = endTime.toString();
		String userId = user.getId();//ここわからなさすぎるて
		ReservationBean reservation = new ReservationBean(roomId, date, start, end, userId);
		return reservation;
	}
	@SuppressWarnings("unlikely-arg-type")
	public void	reserve​(ReservationBean reservation) throws Exception {
		String reservationDate = reservation.getDate();
		String reservationStart = reservation.getStart();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		LocalDate reserveDate = LocalDate.parse(reservationDate);
		LocalTime reserveTime = LocalTime.parse(reservationStart);
		
		LocalDateTime reserveDateTime = LocalDateTime.of(reserveDate, reserveTime);
		
		if(reserveDateTime.isAfter(localDateTime)) {
			throw new Exception("時刻が過ぎているため予約できません");
		}
		
		List<ReservationBean> reserveList = ReservationDao.findByDate​(date);
		for(ReservationBean rs:reserveList) {
			if(rs.getStart().equals(reservationStart)&&rs.getIsDeleted()==0){
				throw new Exception("既に予約されています");
			}
		}
				
		ReservationDao.insert​(reservation);	
	}
	public void cancel​(ReservationBean reservation) throws Exception {
		String reservationDate = reservation.getDate();
		String reservationStart = reservation.getStart();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		LocalDate reserveDate = LocalDate.parse(reservationDate);
		LocalTime reserveTime = LocalTime.parse(reservationStart);
		
		LocalDateTime reserveDateTime = LocalDateTime.of(reserveDate, reserveTime);
		
		if(reserveDateTime.isAfter(localDateTime)) {
			throw new Exception("時刻が過ぎているためキャンセルできません");
		}
		
		List<ReservationBean> reserveList = ReservationDao.findByDate​(date);
		for(ReservationBean rs:reserveList) {
			if(rs.getStart().equals(reservationStart)&&rs.getIsDeleted()==1){
			throw new Exception("既にキャンセルされています");
			}
		}
		ReservationDao.delete​(reservation);	
	}
	
	public String toString() {
		return user.toString()+rooms.toString()+date;
	}
}
