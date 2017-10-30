package com.digisight.platform.ehr;

import java.util.ArrayList;

public class EhrPayload {

	/**
	 * @author Mahesh Reddy Created Date: 26-10-07
	 *
	 */

	private ArrayList<Address> address;

	private ArrayList<Name> name;

	private ArrayList<Telecom> telecom;

	private String gender;

	private String birthDate;

	private ArrayList<Identifier> identifier;

	private String resourceType;

	public ArrayList<Address> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}

	public ArrayList<Name> getName() {
		return name;
	}

	public void setName(ArrayList<Name> name) {
		this.name = name;
	}

	public ArrayList<Telecom> getTelecom() {
		return telecom;
	}

	public void setTelecom(ArrayList<Telecom> telecom) {
		this.telecom = telecom;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public ArrayList<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(ArrayList<Identifier> identifier) {
		this.identifier = identifier;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
}
