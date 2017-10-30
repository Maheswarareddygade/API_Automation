package com.digisight.platform.userInfo;

/**
 * @author Mahesh Reddy Created Date: 26-10-07
 *
 */

public class LocationList {
	private String id;

	private String name;

	private String practiceId;

	private String encounterCount;

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

	public String getPracticeId() {
		return practiceId;
	}

	public void setPracticeId(String practiceId) {
		this.practiceId = practiceId;
	}

	public String getEncounterCount() {
		return encounterCount;
	}

	public void setEncounterCount(String encounterCount) {
		this.encounterCount = encounterCount;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", name = " + name + ", practiceId = " + practiceId + ", encounterCount = "
				+ encounterCount + "]";
	}
}
