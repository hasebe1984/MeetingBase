package jp.co.sys.bean;

import java.io.Serializable;

public class ReservationBean implements Serializable {
	private String date;
	private String end;
	private int id;
	private String roomId;
	private static final long serialVersionUID = 1L;
	private String start;
	private String userID;
	private int isDeleted;

	//	コンストラクタ
	public ReservationBean() {
	}

	public ReservationBean(int id, String roomId, String date, String start, String end, String userID, int isDeleted) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userID = userID;
		this.isDeleted = isDeleted;
	}

	public ReservationBean(String roomId, String date, String start, String end, String userID) {
		this(0, roomId, date, start, end, userID, 0);
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userID = userID;
	}

	public ReservationBean(String userID) {
		this.userID = userID;
	}
	
	public ReservationBean(String date) {
		this.date = date;
	}


	public int getId() {
		return id;
	}

	public int getIsDeleted() {
		return isDeleted;
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

	public String getUserID() {
		return userID;
	}

	@Override
	public String toString() {
		return id + " " + date + " " + start + " " + end + " " + userID + " " + isDeleted + "\n";
	}
}
