package com.digisight.platform.ehr;

public class Identifier {

	/**
	 * @author Mahesh Reddy Created Date: 26-10-07
	 *
	 */

	private String system;

	private String value;

	private String use;

	private Assigner assigner;

	private Type type;

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public Assigner getAssigner() {
		return assigner;
	}

	public void setAssigner(Assigner assigner) {
		this.assigner = assigner;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
