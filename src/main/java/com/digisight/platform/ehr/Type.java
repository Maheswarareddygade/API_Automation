package com.digisight.platform.ehr;

import java.util.ArrayList;

/**
 * @author Mahesh Reddy Created Date: 26-10-07
 *
 */

public class Type {

	private ArrayList<Coding> coding;

	public ArrayList<Coding> getCoding() {
		return coding;
	}

	public void setCoding(ArrayList<Coding> codingList) {
		this.coding = codingList;
	}
}
