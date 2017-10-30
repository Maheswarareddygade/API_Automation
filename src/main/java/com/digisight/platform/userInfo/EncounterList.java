package com.digisight.platform.userInfo;

/**
 * @author Mahesh Reddy Created Date: 26-10-07
 *
 */

public class EncounterList {
	private String created_date;

	private String day_of_birth;

	private String ehr_patient;

	private String status;

	private String date_of_birth;

	private Mrn[] mrn;

	private String event_summary;

	private String has_open_notification;

	private String practice_id;

	private String id;

	private String last_event_time;

	private String first_name;

	private String updated_date;

	private String ehr_pending_order;

	private String practice_location_id;

	private String last_name;

	private String read;

	private String unread_notifications_count;

	private String created_at;

	private String gender;

	private String patient_id;

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getDay_of_birth() {
		return day_of_birth;
	}

	public void setDay_of_birth(String day_of_birth) {
		this.day_of_birth = day_of_birth;
	}

	public String getEhr_patient() {
		return ehr_patient;
	}

	public void setEhr_patient(String ehr_patient) {
		this.ehr_patient = ehr_patient;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Mrn[] getMrn() {
		return mrn;
	}

	public void setMrn(Mrn[] mrn) {
		this.mrn = mrn;
	}

	public String getEvent_summary() {
		return event_summary;
	}

	public void setEvent_summary(String event_summary) {
		this.event_summary = event_summary;
	}

	public String getHas_open_notification() {
		return has_open_notification;
	}

	public void setHas_open_notification(String has_open_notification) {
		this.has_open_notification = has_open_notification;
	}

	public String getPractice_id() {
		return practice_id;
	}

	public void setPractice_id(String practice_id) {
		this.practice_id = practice_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLast_event_time() {
		return last_event_time;
	}

	public void setLast_event_time(String last_event_time) {
		this.last_event_time = last_event_time;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public String getEhr_pending_order() {
		return ehr_pending_order;
	}

	public void setEhr_pending_order(String ehr_pending_order) {
		this.ehr_pending_order = ehr_pending_order;
	}

	public String getPractice_location_id() {
		return practice_location_id;
	}

	public void setPractice_location_id(String practice_location_id) {
		this.practice_location_id = practice_location_id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getUnread_notifications_count() {
		return unread_notifications_count;
	}

	public void setUnread_notifications_count(String unread_notifications_count) {
		this.unread_notifications_count = unread_notifications_count;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	@Override
	public String toString() {
		return "ClassPojo [created_date = " + created_date + ", day_of_birth = " + day_of_birth + ", ehr_patient = "
				+ ehr_patient + ", status = " + status + ", date_of_birth = " + date_of_birth + ", mrn = " + mrn
				+ ", event_summary = " + event_summary + ", has_open_notification = " + has_open_notification
				+ ", practice_id = " + practice_id + ", id = " + id + ", last_event_time = " + last_event_time
				+ ", first_name = " + first_name + ", updated_date = " + updated_date + ", ehr_pending_order = "
				+ ehr_pending_order + ", practice_location_id = " + practice_location_id + ", last_name = " + last_name
				+ ", read = " + read + ", unread_notifications_count = " + unread_notifications_count
				+ ", created_at = " + created_at + ", gender = " + gender + ", patient_id = " + patient_id + "]";
	}
}
