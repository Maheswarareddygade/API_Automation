package com.digisight.platform.ehr;

import java.util.List;

public class Name {

	/**
	 * @author Mahesh Reddy Created Date: 26-10-07
	 *
	 */

	private List<String> given;

	private List<String> family;

	public List<String> getGiven() {
		return given;
	}

	public void setGiven(List<String> given) {
		this.given = given;
	}

	public List<String> getFamily() {
		return family;
	}

	public void setFamily(List<String> family) {
		this.family = family;
	}
}
