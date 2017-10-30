package com.digisight.platform.userInfo;

public class Practices {

	/**
	 * @author Mahesh Reddy Created Date: 23-10-07
	 *
	 */

	private String id;

	private String phone;

	private String orgConnectionType;

	private String email;

	private String address;

	private String website;

	private String zipCode;

	private String name;

	private String state;

	private String city;

	private String country;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrgConnectionType() {
		return orgConnectionType;
	}

	public void setOrgConnectionType(String orgConnectionType) {
		this.orgConnectionType = orgConnectionType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", phone = " + phone + ", orgConnectionType = " + orgConnectionType
				+ ", email = " + email + ", address = " + address + ", website = " + website + ", zipCode = " + zipCode
				+ ", name = " + name + ", state = " + state + ", city = " + city + ", country = " + country + "]";
	}
}
