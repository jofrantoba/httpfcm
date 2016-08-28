package com.jofrantoba.httpfcm;

public class StatusIds {
	private String id;
	private String statusMessage;
	private String newId;
	private Boolean isCorrect;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	
	
}
