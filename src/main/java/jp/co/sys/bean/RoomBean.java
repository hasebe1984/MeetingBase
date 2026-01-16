package jp.co.sys.bean;

import java.io.Serializable;

public class RoomBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public RoomBean() {
		super();
	}

	public RoomBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public RoomBean(String name) {
		super();
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
		return id + " " + name + "\n";
	}
}