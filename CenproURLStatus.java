package com.kwg.model;

import java.util.Date;

public class CenproURLStatus {
	private boolean isWorking;
	private Integer statusCode;
	private String status;
	private Date timestamp;
	
	
	
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isWorking() {
		return isWorking;
	}
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "CenproURLStatus [isWorking=" + isWorking + ", statusCode=" + statusCode + ", status=" + status + "]";
	}
	
	

}
