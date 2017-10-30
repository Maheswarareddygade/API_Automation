package com.digisight.platform.userInfo;

/**
 * @author Mahesh Reddy Created Date: 26-10-07
 *
 */

public class FilterLocationList {
	private String name;

	private String[] locationIds;

	private String encounterCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getLocationIds() {
		return locationIds;
	}

	public void setLocationIds(String[] locationIds) {
		this.locationIds = locationIds;
	}

	public String getEncounterCount() {
		return encounterCount;
	}

	public void setEncounterCount(String encounterCount) {
		this.encounterCount = encounterCount;
	}

	@Override
	public String toString() {
		return "ClassPojo [name = " + name + ", locationIds = " + locationIds + ", encounterCount = " + encounterCount
				+ "]";
	}
}
