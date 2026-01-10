package jp.co.sys.bean;

import java.io.Serializable;
import java.util.ArrayList;
//　web連携164みまねて、エクステンドしたらいけたけどいいの？？
public class RoomBean extends ArrayList<RoomBean> implements Serializable{
	private static final long serialVersionUID = 1L;
	String id;
	String name;

	public RoomBean() {
		super();
	}

	public RoomBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return id + name;
	}
}