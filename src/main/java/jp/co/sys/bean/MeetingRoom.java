package jp.co.sys.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jp.co.sys.dao.ReservationDao;
import jp.co.sys.dao.RoomDao;
import jp.co.sys.dao.UserDao;
import jp.co.sys.util.ReservationList;
import jp.co.sys.util.RoomList;
import jp.co.sys.util.UserList;

public class MeetingRoom implements Serializable {
	//フィールド
	private static final long serialVersionUID = 1L;
	private static int INTERVAL = 60;
	private static String[] PERIOD = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" };
	private String date;
	private RoomList rooms;
	private UserBean user;
	private UserList users;

	//コンストラクタ
	public MeetingRoom() {
		this.rooms = RoomDao.findAll();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.date = currentDate.format(dateTimeFormatter);
	}

	//メソッド
	/**
	*会議室予約システムの利用日を返します。
	*@return 利用日
	*/
	public String getDate() {
		return date;
	}

	/**
	*利用日更新
	*会議室予約システムの利用日を設定します。
	*@param 利用日
	*/
	public void setDate​(String date) {
		this.date = date;
	}

	/**
	*利用会議室取得
	*会議室IDがroomIdの会議室を返します。
	*@return RoomList 会議室(見つからない場合は、nullを返却)
	*/
	public RoomList getRooms() {
		return rooms;
	}

	/**
	*会議室予約システムにログインしている利用者を返します。
	*@return UserBean 利用者
	*/
	public UserBean getUser() {
		return user;
	}

	/**
	*利用時間帯の配列を返す。
	*@return String[] 開始時刻の配列
	*/
	public static String[] getPeriod() {
		return PERIOD;
	}

	/**
	*利用会議室取得
	*会議室IDがroomIdの会議室を返します。
	*@param roomId 会議室ID
	*@return RoomBean 会議室(見つからない場合は、nullを返却)
	*/
	public RoomBean getRoom​(String roomId) {
		for (RoomBean room : rooms) {
			if (room.getId().equals(roomId)) {
				return room;
			}
		}
		return null;
	}

	/**
	*roomIdの会議室が配列に格納されている添字を返します。
	*@param roomId 会議室ID
	*@return int 配列の添字
	*@throws java.lang.IndexOutOfBoundsException 会議室が存在しない場合
	*/
	private int roomIndex​(String roomId) throws IndexOutOfBoundsException {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getId().equals(roomId)) {
				return i;
			}
		}
		throw new IndexOutOfBoundsException();
	}

	/**
	*利用開始時刻に対応する利用時間帯の添え字を計算します。
	*@param start String 利用開始時刻
	*@return int 時間帯番号
	*@throws java.lang.IndexOutOfBoundsException 利用時間帯の範囲外
	*/
	private int startPeriod​(String start) throws IndexOutOfBoundsException {
		int periodIndex = 0;
		for (int i = 0; i < PERIOD.length; i++) {
			if (PERIOD[i].equals(start)) {
				periodIndex = i;
				return periodIndex;
			}
		}
		throw new IndexOutOfBoundsException();
	}

	/**
	*会議室予約システムの利用日における予約状況を返します。
	*@return ReservationBean[][] 会議室，時間帯ごとの予約状況
	*/
	public ReservationBean[][] getReservations() {
		int roomSize = rooms.size();
		ReservationBean reservations[][] = new ReservationBean[roomSize][PERIOD.length];
		ReservationList reserveList = ReservationDao.findByDate​(this.date);
		if (reserveList == null) {
			return reservations;
		}
		for (ReservationBean reserve : reserveList) {
			int roomInd = roomIndex​(reserve.getRoomId());
			String ReserveStart = reserve.getStart();
			LocalTime time = LocalTime.parse(ReserveStart);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			String start = formatter.format(time);
			int startInd = startPeriod​(start);
			reservations[roomInd][startInd] = reserve;
		}
		return reservations;
	}

	/**
	*認証
	*会議室予約システムにログインします。
	*@param id String 利用者ID , password String パスワード
	*@return ログインできた場合はtrue，それ以外の場合false
	*/
	public boolean login​(String id, String password) {
		UserBean result = UserDao.certificate​(id, password);
		if (result != null) {
			this.user = result;
			return true;
		} else {
			return false;
		}
	}

	/**
	*予約生成
	*予約日で会議室と時間帯を指定した会議室予約情報を生成します。また、開始時刻を基に終了時刻を生成し利用する。
	*@param roomId String 会議室ID, start String 利用開始時刻(HH:mm形式で受け取る事を想定)
	*@return ReservationBean 会議室予約情報
	*/
	public ReservationBean createReservation​(String roomId, String start) {
		LocalTime startTime = LocalTime.parse(start);
		LocalTime endTime = startTime.plusMinutes(INTERVAL);
		String end = endTime.toString();
		String userId = user.getId();//ここわからなさすぎるて
		ReservationBean reservation = new ReservationBean(roomId, date, start, end, userId);
		return reservation;
	}

	/**
	*予約登録
	*会議室予約情報で会議室Daoを利用し、予約します。
	*@param reservation ReservationBean 会議室予約情報
	*@return 戻値の説明
	*@throws java.lang.Exception 予約ができない場合に次のメッセージの例外を投げます。
	*			予約済みの場合："既に予約されています"
	*			現在時刻が予約時間を過ぎている場合："時刻が過ぎているため予約できません"
	*/
	public void reserve​(ReservationBean reservation) throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();

		LocalDate reserveDate = LocalDate.parse(reservation.getDate());
		LocalTime reserveTime = LocalTime.parse(reservation.getStart());

		LocalDateTime reserveDateTime = LocalDateTime.of(reserveDate, reserveTime);

		if (reserveDateTime.isBefore(localDateTime)) {
			throw new Exception("時刻が過ぎているため予約できません");
		}

		ReservationList reserveList = ReservationDao.findByDate​(this.date);
		if (reserveList != null) {
			for (ReservationBean rs : reserveList) {
				String reservedRoomId = rs.getRoomId();
				if (reservedRoomId.equals(reservation.getRoomId()) && rs.getDate().equals(reservation.getStart())
						&& rs.getIsDeleted() == 0) {
					throw new Exception("既に予約されています");
				}
			}
		}
		ReservationDao.insert​(reservation);
	}

	/**
	*予約キャンセル
	*会議室予約情報で会議室をキャンセルします。
	*@param reservation ReservationBean 会議室予約情報
	*@throws java.lang.Exception - キャンセルができない場合に次のメッセージの例外を投げます。 
	*			キャンセル済みの場合："既にキャンセルされています" 
	*			現在時刻が予約時間を過ぎている場合："時刻が過ぎているためキャンセルできません"
	*/
	public void cancel​(ReservationBean reservation) throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();

		LocalDate reserveDate = LocalDate.parse(reservation.getDate());
		LocalTime reserveTime = LocalTime.parse(reservation.getStart());

		LocalDateTime reserveDateTime = LocalDateTime.of(reserveDate, reserveTime);

		if (reserveDateTime.isBefore(localDateTime)) {
			throw new Exception("時刻が過ぎているためキャンセルできません");
		}
		ReservationBean cancelReserve = ReservationDao.findById​(reservation.getId());
		if (cancelReserve.getIsDeleted() == 1) {
			throw new Exception("既にキャンセルされています");
		}
		ReservationDao.delete​(reservation);
	}

	/**
	*利用者登録生成
	*登録情報がセットされた利用者情報にIDを追加して利用者登録情報として完成させ、DBに追加する。
	*@param UserBean 利用者情報
	*@return UserBean 利用者情報
	*@throws Exception
	*/

	public UserBean createUser(UserBean addUser) throws Exception {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy");
		String idNow = now.format(dtf);
		UserList usersNowId = UserDao.getNowId(idNow);//DAOからuserNowIdでid検索する
		int usersNowIdSize = usersNowId.size();
		if (usersNowId != null) {
			usersNowIdSize++;
		}
		String idSize = String.format("%05d", usersNowIdSize);
		String userId = idNow + idSize;
		addUser.setId(userId);

		UserList allUser = UserDao.findAll();
		if (allUser != null) {
			for (UserBean us : allUser) {
				String usId = us.getId();
				if (usId.equals(userId)) {
					throw new Exception("既に登録されています");
				}
			}
		}
		UserDao.insert​(addUser);
		return addUser;
	}

	/**
	 *UserBeanの内容でDBを変更する
	 *会員の編集処理
	 *@param UserBean
	 *@return DBが更新できたらtrue、失敗したらfalse  
	 *@throws Exception
	 */
	public boolean editUser(UserBean user) throws Exception {
		UserBean userEdit = UserDao.findById(user.getId());
		if (userEdit==null) {
			throw new Exception("存在しないユーザーです");
		}
		if (userEdit.getIsDeleted().equals(1)) {
			throw new Exception("削除されたユーザーです");
		}
		if (user.getId() != this.user.getId() && this.user.getIsAdmin().equals(0)) {
			throw new Exception("変更できないユーザーです。");
		}
		boolean isSuccess = UserDao.update(user);
		return isSuccess;
	}

	/**
	 *UserBeanのidを元に、isDeleteを1に変更する
	 *会員の削除処理
	 *@param UserBean
	 *@return DBで論理削除できたらtrue、失敗したらfalse  
	 *@throws Exception
	 */
	public boolean deleteUser(UserBean user) throws Exception {
		UserBean deleteUser = UserDao.findById(user.getId());
		if (deleteUser==null) {
			throw new Exception("存在しないユーザーです");
		}
		if (deleteUser.getIsDeleted().equals(1)) {
			throw new Exception("既に削除されています");
		}
		if (user.getId() != this.user.getId() && this.user.getIsAdmin().equals(0)) {
			throw new Exception("削除できないユーザーです。");
		}
		ReservationList reserveList = ReservationDao.finduserID(user.getId());
		if(reserveList !=null) {
			LocalDateTime now = LocalDateTime.now();		
			for(ReservationBean rs:reserveList) {
				LocalDate rsDate = LocalDate.parse(rs.getDate());
				LocalTime rsTime = LocalTime.parse(rs.getEnd());
				LocalDateTime rsDateTime = LocalDateTime.of(rsDate, rsTime);
				if (rsDateTime.isAfter(now)) {
					throw new Exception("予約があるため削除できません");
				}
			}
		}
		boolean isSuccess = UserDao.delete​(user);
		return isSuccess;
	}

	//	==========
	//	長谷部作成
	/**
	*userテーブルの全データの取得（削除フラグが立っていないもの）
	*会員一覧表示の為。
	*@return UserList
	*/
	public UserList getUsers() {
		this.users = UserDao.findAll();
		return users;
	}

	/**
	*roomテーブルの全データの取得（削除フラグが立っていないもの）
	*会議室一覧表示の為。（登録・編集・削除後に再取得する時に使用）
	*@return RoomList
	*/
	public void reloadRooms() {
		this.rooms = RoomDao.findAll();
	}

	/**
	 *RoomBeanの内容をDBに追加する
	 *会議室の追加処理
	 *@param RoomBean
	 *@return DBに追加できたらtrue、失敗したらfalse 
	 *@throws Exception
	 */
	public RoomBean addRoom(RoomBean room) throws Exception {
		int num = Integer.parseInt(room.getId());
		int count = RoomDao.findAll().size() + 1;
		String roomsNum = String.format("%02d", count);
		String formatRoomNum = String.format("%02d", num);
		String roomId = formatRoomNum + roomsNum;
		room.setId(roomId);
		RoomList allRoom = RoomDao.findAll();
		if (allRoom != null) {
			for (RoomBean rm : allRoom) {
				String rmId = rm.getId();
				if (rmId.equals(roomId)) {
					throw new Exception("既に登録されています");
				}
			}
		}
		RoomDao.insert(room);
		return room;

	}

	/**
	*RoomBeanの内容でDBを変更する
	*会議室の編集処理
	*@param RoomBean
	*@return DBが更新できたらtrue、失敗したらfalse 
	*@throws Exception
	*/
	public boolean editRoom(RoomBean room) throws Exception {

		boolean isSuccess = RoomDao.update(room);
		return isSuccess;
	}

	/**
	 *RoomBeanの内容でDBを変更する
	 *会議室の削除処理
	 *@param RoomBean
	 *@return DBで物理削除できたらtrue、失敗したらfalse 
	 *@throws Exception
	 */
	public boolean deleteRoom(RoomBean room) throws Exception {
		
		boolean isSuccess = RoomDao.delete(room);
		return isSuccess;
	}

	public String toString() {
		return user.toString() + rooms.toString() + this.date;
	}
}
