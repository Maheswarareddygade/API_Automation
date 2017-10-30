package com.digisight.platform.userInfo;


/**
 * @author Mahesh Reddy Created Date: 26-10-07
 *
 */

public class Physicians {
	
	private String id;

	private String lastName;

	private String userDebugMode;

	private Specialties[] specialties;

	private String email;

	private String name;

	private String userId;

	private String accountType;

	private String invertFundusImage;

	private String practiceId;

	private String firstName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserDebugMode() {
		return userDebugMode;
	}

	public void setUserDebugMode(String userDebugMode) {
		this.userDebugMode = userDebugMode;
	}

	public Specialties[] getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Specialties[] specialties) {
		this.specialties = specialties;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getInvertFundusImage() {
		return invertFundusImage;
	}

	public void setInvertFundusImage(String invertFundusImage) {
		this.invertFundusImage = invertFundusImage;
	}

	public String getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(String practiceId) {
		this.practiceId = practiceId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
