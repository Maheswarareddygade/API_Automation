package com.digisight.platform.userInfo;

public class PracticeLocations {

	/**
	 * @author Mahesh Reddy Created Date: 23-10-07
	 *
	 */

	private String id;

	private String name;

	private String encounterCount;

	private String practiceId;

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

	public String getEncounterCount() {
		return encounterCount;
	}

	public void setEncounterCount(String encounterCount) {
		this.encounterCount = encounterCount;
	}

	public String getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(String practiceId) {
		this.practiceId = practiceId;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", name = " + name + ", encounterCount = " + encounterCount + ", practiceId = "
				+ practiceId + "]";
	}
}
