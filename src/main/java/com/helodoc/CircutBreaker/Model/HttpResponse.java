package com.helodoc.CircutBreaker.Model;

public class HttpResponse {
	private String responseString;
	private boolean isSuccess;
	private String exception;
	private int responseCode;
	public HttpResponse(){};
	public HttpResponse(String responseString, boolean isSuccess, String exception, int responseCode) {
		super();
		this.responseString = responseString;
		this.isSuccess = isSuccess;
		this.exception=exception;
		this.responseCode=responseCode;
	}

	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getResponseString() {
		return responseString;
	}
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
}
