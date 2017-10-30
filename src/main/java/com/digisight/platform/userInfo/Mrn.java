package com.digisight.platform.userInfo;

/**
 * @author Mahesh Reddy Created Date: 26-10-07
 *
 */

public class Mrn {

	private String assigner_display;

	private String system;

	private String deleted_at;

	private String assigner_reference;

	private String value;

	private String patient_id;

	private String practice_id;

	private String master;

	public String getAssigner_display() {
		return assigner_display;
	}

	public void setAssigner_display(String assigner_display) {
		this.assigner_display = assigner_display;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getAssigner_reference() {
		return assigner_reference;
	}

	public void setAssigner_reference(String assigner_reference) {
		this.assigner_reference = assigner_reference;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getPractice_id() {
		return practice_id;
	}

	public void setPractice_id(String practice_id) {
		this.practice_id = practice_id;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "ClassPojo [assigner_display = " + assigner_display + ", system = " + system + ", deleted_at = "
				+ deleted_at + ", assigner_reference = " + assigner_reference + ", value = " + value + ", patient_id = "
				+ patient_id + ", practice_id = " + practice_id + ", master = " + master + "]";
	}
}
