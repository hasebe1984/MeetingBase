package jp.co.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.sys.bean.RoomBean;
import jp.co.sys.util.DatabaseConnectionProvider;
/**
 * データベース「meetingroomb」のテーブル「room」を操作するクラスです。
 * @author 池田喜一郎
 * @version 1.0
 */
//web連携164みまねて、エクステンドしたらいけたけどいいの？？
public class RoomDao extends ArrayList<RoomBean> {
	/**
	 * デフォルトコンストラクタ
	 */
	private RoomDao() {
	}

	/**
	 * @return
	 * @throws
	 */
	
//	ストリング配列をルームビーン配列にキャストできない
//	エラーでないけど、例外発生した
//	public static RoomBean[] findAll() {
//		ArrayList<RoomBean> list = new ArrayList<RoomBean>();
//		String sql = "SELECT * FROM room";
//		try (Connection db = DatabaseConnectionProvider.getConnection();
//				PreparedStatement pstmt = db.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery()) {
//			while (rs.next()) {
//				String roomid = rs.getString("id");
//				String roomname = rs.getString("name");
//				RoomBean rb = new RoomBean(roomid, roomname);
//				list.add(rb);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		RoomBean[] roomlist = (RoomBean[])list.toArray();
//		return roomlist;
//	}
////	https://qiita.com/j-work/items/d114bd9fcf7e5e88e659
	
//	リザルトセットを配列にセットしていく方法を、やっぱ探す
//	public static RoomBean[] findAll() {
//		String sql = "SELECT * FROM room";
////		RoomBean[] roomlist;
//		try (Connection db = DatabaseConnectionProvider.getConnection();
//				PreparedStatement pstmt = db.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery()) {
//			rs.last();
//			int rowcount = rs.getRow();		
//			RoomBean[] roomlist= new RoomBean[rowcount];
//			String[] a = new String[rowcount];
//			while (rs.next()) {
//				String roomid = rs.getString("id");
//				String roomname = rs.getString("name");
//				for (int i = 0; i < rowcount; i++) {
//					 a[i] = roomid;
//					 a[i] = roomname;
//				}
//				roomlist = a;
//				return roomlist;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	} https://tech.kurojica.com/archives/15721/

//	通るけど、アレイリスト前提なのでNG
//	public static RoomBean findAll() {
//		RoomBean roomlist = new RoomBean();
//		String sql = "SELECT * FROM room";
//		try (Connection db = DatabaseConnectionProvider.getConnection();
//				PreparedStatement pstmt = db.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery()) {
//			while (rs.next()) {
//				String roomid = rs.getString("id");
//				String roomname = rs.getString("name");
//				RoomBean rb = new RoomBean(roomid, roomname);
//				roomlist.add(rb);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return roomlist;
//	}
	
	//	追加・削除・編集のメソッド　名前は仮で
	/**
	 * @param name　会議室名
	 * @return　テーブル「room」へのデータ挿入真偽
	 */
	public static boolean insert(String name) {
		int ret = -1;
		String sql = "INSERT INTO room VALUES (?,?)";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setInt(1, 1111); //仮
			pstmt.setString(2, "仮会議室"); //仮
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}

	/**
	 * @param name　会議室名
	 * @return　テーブル「room」のデータ「name」のデータ変更真偽
	 */
	public static boolean update(String name) {
		int ret = -1;
		String sql = "UPDATE room SET name =? WHERE id =?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setString(1, "変更できた会議室"); //仮
			pstmt.setInt(2,1111); //仮
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}
	
	/**
	 * @param id　会議室ID
	 * @return　テーブル「room」のデータ「id」のデータ削除真偽
	 */
	public static boolean delete(int id) {
		int ret = -1;
		String sql = "DELETE FROM room WHERE id=?";
		try (Connection db = DatabaseConnectionProvider.getConnection();
				PreparedStatement pstmt = db.prepareStatement(sql)) {
			pstmt.setInt(1, 1111); //仮
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret != 0;
	}
}