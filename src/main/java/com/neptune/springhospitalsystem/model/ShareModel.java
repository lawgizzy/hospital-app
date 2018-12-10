package com.neptune.springhospitalsystem.model;

import java.util.ArrayList;
import java.util.List;

public class ShareModel {
private String shortMessage = "";
private String firstName = "";
private int adminId = 0;
private int patientId = 0;
private int amountPaid = 0;
private String patientFname = "";
private String patientMidName = "";
private String patientFullName = "";
public String getPatientFullName() {
	return patientFullName;
}

public void setPatientFullName(String patientFname, String patientMidName, String patientLname) {
	this.patientFullName = patientFname+" "+patientMidName+" "+patientLname;
}

public String getPatientMidName() {
	return patientMidName;
}

public void setPatientMidName(String patientMidName) {
	this.patientMidName = patientMidName;
}

private String patientLname = "";
private int serial;
private int paymentId;
private String patientEmail = "";
public String getPatientEmail() {
	return patientEmail;
}

public void setPatientEmail(String patientEmail) {
	this.patientEmail = patientEmail;
}

public String getPatientPhoneHome() {
	return patientPhoneHome;
}

public void setPatientPhoneHome(String patientPhoneHome) {
	this.patientPhoneHome = patientPhoneHome;
}

public String getPatientPhoneOffice() {
	return patientPhoneOffice;
}

public void setPatientPhoneOffice(String patientPhoneOffice) {
	this.patientPhoneOffice = patientPhoneOffice;
}

public String getPatientAddress() {
	return patientAddress;
}

public void setPatientAddress(String patientAddress) {
	this.patientAddress = patientAddress;
}

public String getPaymentDate() {
	return paymentDate;
}

public void setPaymentDate(String paymentDate) {
	this.paymentDate = paymentDate;
}

public String getPaymentDescription() {
	return paymentDescription;
}

public void setPaymentDescription(String paymentDescription) {
	this.paymentDescription = paymentDescription;
}

private String patientPhoneHome = "";
private String patientPhoneOffice = "";
private String patientAddress = "";
private String paymentDate = "";
private String paymentDescription = "";

private ArrayList<ShareModel> patientData = new ArrayList<>();

public int getPaymentId() {
	return paymentId;
}

public void setPaymentId(int paymentId) {
	this.paymentId = paymentId;
}

public int getSerial() {
	return serial;
}

public void setSerial(int serial) {
	this.serial = serial;
}

public String getPatientFname() {
	return patientFname;
}

public void setPatientFname(String patientFname) {
	this.patientFname = patientFname;
}

public String getPatientLname() {
	return patientLname;
}

public void setPatientLname(String patientLname) {
	this.patientLname = patientLname;
}

public ArrayList<ShareModel> getPatientData() {
	return patientData;
}

public void setPatientData(List<ShareModel> patientData) {
this.patientData = (ArrayList<ShareModel>) patientData;

}

public int getPatientId() {
	return patientId;
}

public void setPatientId(int patientId) {
	this.patientId = patientId;
}

public int getAmountPaid() {
	return amountPaid;
}

public void setAmountPaid(int amountPaid) {
	this.amountPaid = amountPaid;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public int getAdminId() {
	return adminId;
}

public void setAdminId(int adminId) {
	this.adminId = adminId;
}

public String getShortMessage() {
	return shortMessage;
}

public void setShortMessage(String shortMessage) {
	this.shortMessage = shortMessage;
}

}
