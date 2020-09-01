package com.application.in.Response;

public class Response {
	private int statuscode;
	private String statusMessage;

	public Response() {
	}

	public Response(int statusCode, String statusMessage) {
		this.statuscode = statusCode;
		this.statusMessage = statusMessage;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
