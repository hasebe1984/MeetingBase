package jp.co.sys.bean;

import java.io.Serializable;

public class ReservationBean implements Serializable {
	private String date;
	private String end;
	private int id;
	private String roomId;
	private static final long serialVersionUID = 1L;
	private String start;
	private String userId;

	//	コンストラクタ
	public ReservationBean() {
	}

	public ReservationBean(int id, String roomId, String date, String start, String end, String userId) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}

	public ReservationBean(String roomId, String date, String start, String end, String userId) {
		this(0, roomId, date, start, end, userId);
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}
	
	public ReservationBean(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomId() {
		return roomId;
	}

	public String getDate() {
		return date;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return id + " " + date + " " + start + " " + end + " " + userId + "\n";
	}
}
