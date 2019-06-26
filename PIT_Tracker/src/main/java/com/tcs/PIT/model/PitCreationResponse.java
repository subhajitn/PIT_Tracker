package com.tcs.PIT.model;

public class PitCreationResponse {

	private String responseCode;
	private String responseMessage;
	private Long pitId;
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
	public Long getPitId() {
		return pitId;
	}
	public void setPitId(Long pitId) {
		this.pitId = pitId;
	}
	@Override
	public String toString() {
		return "PitCreationResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", pitId=" + pitId + "]";
	}
	
}
