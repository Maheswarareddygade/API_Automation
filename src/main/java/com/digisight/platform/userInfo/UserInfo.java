package com.digisight.platform.userInfo;

public class UserInfo {

	/**
	 * @author Mahesh Reddy Created Date: 23-10-07
	 *
	 */

	private String lastName;

	private int phone;

	private String userDebugMode;

	private String appId;

	private String state;

	private PracticeLocations[] practiceLocations;

	private Physician physician;

	private String country;

	private String city;

	private Practices[] practices;

	private String id;

	private String updatedAt;

	private String username;

	private String system;

	private int postalCode;

	private String deviceName;

	private String email;

	private String appVersion;

	private String createdAt;

	private String firstName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getUserDebugMode() {
		return userDebugMode;
	}

	public void setUserDebugMode(String userDebugMode) {
		this.userDebugMode = userDebugMode;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public PracticeLocations[] getPracticeLocations() {
		return practiceLocations;
	}

	public void setPracticeLocations(PracticeLocations[] practiceLocations) {
		this.practiceLocations = practiceLocations;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Practices[] getPractices() {
		return practices;
	}

	public void setPractices(Practices[] practices) {
		this.practices = practices;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "ClassPojo [lastName = " + lastName + ", phone = " + phone + ", userDebugMode = " + userDebugMode
				+ ", appId = " + appId + ", state = " + state + ", practiceLocations = " + practiceLocations
				+ ", physician = " + physician + ", country = " + country + ", city = " + city + ", practices = "
				+ practices + ", id = " + id + ", updatedAt = " + updatedAt + ", username = " + username + ", system = "
				+ system + ", postalCode = " + postalCode + ", deviceName = " + deviceName + ", email = " + email
				+ ", appVersion = " + appVersion + ", createdAt = " + createdAt + ", firstName = " + firstName + "]";
	}
}
