package com.digisight.platform.userInfo;

/**
 * @author Mahesh Reddy Created Date: 26-10-07
 *
 */

public class Specialties {

	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", name = " + name + "]";
	}
}
