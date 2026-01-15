package jp.co.sys.stub.ikeda;

import jp.co.sys.bean.MeetingRoom;
import jp.co.sys.bean.ReservationBean;

public class MRTest {

	public static void main(String[] args) {
		MeetingRoom mr = new MeetingRoom();
		//		RoomBean aa = mr.getRoom​("0201");　OK
		ReservationBean[][] aa = mr.getReservations();
		System.out.println(aa);
		//  MeetingRoom()は、ヌルポがでるけど、user.toString()に値が入れば大丈夫。

	}
}