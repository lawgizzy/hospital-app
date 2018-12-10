package com.neptune.springhospitalsystem.model;

public class PostPaymentModel {
	private String patientId = "";
	private String description = "";
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	private String amountPaid = "";
}
