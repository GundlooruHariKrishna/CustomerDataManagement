package com.tesla.customer.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStructure<Y> {

	private Integer statusCode;

	private Y data;

	private String message;

	private LocalDateTime timeStamp;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Y getData() {
		return data;
	}

	public void setData(Y data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
