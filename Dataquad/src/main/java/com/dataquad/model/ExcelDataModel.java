package com.dataquad.model;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
public class ExcelDataModel
{
	@Id
	@Email
	private String emailId;	
	private String name;
	private String grade;
	private String reference;
	private String recuriter;
	private String team;
	private String mode;
	private String sillSet;
	private String marketingVisa;
	private String actualVisa;
	private String experience;
	private String marketingContact;
	private String personalContact;
	private String location;
	private String originalDob;
	private String editedDob;
	private String linkedinUrl;
	private String relocation;
	private String billRate;
	private String payRoll;
	private String marketingStartDate;
	private String vendorStatus;
//	public String getsNo() {
//		return sNo;
//	}
//	public void setsNo(String sNo) {
//		this.sNo = sNo;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getRecuriter() {
		return recuriter;
	}
	public void setRecuriter(String recuriter) {
		this.recuriter = recuriter;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getSillSet() {
		return sillSet;
	}
	public void setSillSet(String sillSet) {
		this.sillSet = sillSet;
	}
	public String getMarketingVisa() {
		return marketingVisa;
	}
	public void setMarketingVisa(String marketingVisa) {
		this.marketingVisa = marketingVisa;
	}
	public String getActualVisa() {
		return actualVisa;
	}
	public void setActualVisa(String actualVisa) {
		this.actualVisa = actualVisa;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getMarketingContact() {
		return marketingContact;
	}
	public void setMarketingContact(String marketingContact) {
		this.marketingContact = marketingContact;
	}
	public String getPersonalContact() {
		return personalContact;
	}
	public void setPersonalContact(String personalContact) {
		this.personalContact = personalContact;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOriginalDob() {
		return originalDob;
	}
	public void setOriginalDob(String originalDob) {
		this.originalDob = originalDob;
	}
	public String getEditedDob() {
		return editedDob;
	}
	public void setEditedDob(String editedDob) {
		this.editedDob = editedDob;
	}
	public String getLinkedinUrl() {
		return linkedinUrl;
	}
	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}
	public String getRelocation() {
		return relocation;
	}
	public void setRelocation(String relocation) {
		this.relocation = relocation;
	}
	public String getBillRate() {
		return billRate;
	}
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}
	public String getPayRoll() {
		return payRoll;
	}
	public void setPayRoll(String payRoll) {
		this.payRoll = payRoll;
	}
	public String getMarketingStartDate() {
		return marketingStartDate;
	}
	public void setMarketingStartDate(String marketingStartDate) {
		this.marketingStartDate = marketingStartDate;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	@Override
	public String toString() {
		return "ExcelDataModel [name=" + name + ", grade=" + grade + ", reference=" + reference
				+ ", recuriter=" + recuriter + ", team=" + team + ", mode=" + mode + ", sillSet=" + sillSet
				+ ", marketingVisa=" + marketingVisa + ", actualVisa=" + actualVisa + ", experience=" + experience
				+ ", marketingContact=" + marketingContact + ", personalContact=" + personalContact + ", emailId="
				+ emailId + ", location=" + location + ", originalDob=" + originalDob + ", editedDob=" + editedDob
				+ ", linkedinUrl=" + linkedinUrl + ", relocation=" + relocation + ", billRate=" + billRate
				+ ", payRoll=" + payRoll + ", marketingStartDate=" + marketingStartDate + ", vendorStatus="
				+ vendorStatus + "]";
	}
	public ExcelDataModel(String name, String grade, String reference, String recuriter, String team,
			String mode, String sillSet, String marketingVisa, String actualVisa, String experience,
			String marketingContact, String personalContact, String emailId, String location, String originalDob,
			String editedDob, String linkedinUrl, String relocation, String billRate, String payRoll,
			String marketingStartDate, String vendorStatus) {
		super();
	
		this.name = name;
		this.grade = grade;
		this.reference = reference;
		this.recuriter = recuriter;
		this.team = team;
		this.mode = mode;
		this.sillSet = sillSet;
		this.marketingVisa = marketingVisa;
		this.actualVisa = actualVisa;
		this.experience = experience;
		this.marketingContact = marketingContact;
		this.personalContact = personalContact;
		this.emailId = emailId;
		this.location = location;
		this.originalDob = originalDob;
		this.editedDob = editedDob;
		this.linkedinUrl = linkedinUrl;
		this.relocation = relocation;
		this.billRate = billRate;
		this.payRoll = payRoll;
		this.marketingStartDate = marketingStartDate;
		this.vendorStatus = vendorStatus;
	}
	public ExcelDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	



}
