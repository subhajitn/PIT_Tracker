package com.tcs.PIT.model;

public class PitCreationResponse {

	private String responseCode;
	private String responseMessage;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "PitCreationResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
	
}
