package jp.co.sys.bean;

import java.io.Serializable;

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
		return ;
	}
	public UserBean	getUser() {
		return ;
	}
	public boolean login​(String id, String password) {
		return ;
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
