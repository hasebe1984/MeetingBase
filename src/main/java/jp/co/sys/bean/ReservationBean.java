package jp.co.sys.bean;

import java.io.Serializable;

/**
 * ReservationBeanを定義するクラスです。
 * @author 小山祐貴
 */
public class ReservationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String roomId;
	private String date;
	private String start;
	private String end;
	private String userId;

	/**
	 * デフォルトコンストラクタ
	 */
	public ReservationBean() {
	}

	/**
	 * フィールドを全設定するコンストラクタです。
	 * @param id reservationテーブルのカラム「id」です。
	 * @param roomId reservationテーブルのカラム「roomId」です。
	 * @param date reservationテーブルのカラム「date」です。
	 * @param start reservationテーブルのカラム「start」です。
	 * @param end reservationテーブルのカラム「end」です。
	 * @param userId reservationテーブルのカラム「userId」です。
	 */
	public ReservationBean(int id, String roomId, String date, String start, String end, String userId) {
		this.id = id;
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}

	/**
	 * 予約生成する為のコンストラクタです。
	 * @param roomId reservationテーブルのカラム「roomId」です。
	 * @param date reservationテーブルのカラム「date」です。
	 * @param start reservationテーブルのカラム「start」です。
	 * @param end reservationテーブルのカラム「end」です。
	 * @param userId reservationテーブルのカラム「userId」です。
	 */
	public ReservationBean(String roomId, String date, String start, String end, String userId) {
		this(0, roomId, date, start, end, userId);
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}

	/**
	 * 予約削除する為のコンストラクタです。
	 * @param id reservationテーブルのカラム「id」です。
	 */
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
