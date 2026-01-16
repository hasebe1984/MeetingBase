package jp.co.sys.stub.ikeda;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.util.DatabaseConnectionProvider;
import jp.co.sys.util.RoomList;
=======
import jp.co.sys.bean.MeetingRoom;
import jp.co.sys.bean.ReservationBean;
>>>>>>> 288fa867cce203866548451c71ac2053c0a0d946

public class MRTest {

	public static void main(String[] args) {
<<<<<<< HEAD
		RoomList roomlist = new RoomList();
		String sql = "SELECT * FROM room";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String roomid = rs.getString("id");
				String roomname = rs.getString("name");
				RoomBean rb = new RoomBean(roomid, roomname);
				roomlist.add(rb);
				System.out.println(rb);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
=======
		MeetingRoom mr = new MeetingRoom();
		//		RoomBean aa = mr.getRoom​("0201");　OK
		ReservationBean[][] aa = mr.getReservations();
		System.out.println(aa);
		//  MeetingRoom()は、ヌルポがでるけど、user.toString()に値が入れば大丈夫。

>>>>>>> 288fa867cce203866548451c71ac2053c0a0d946
	}
}