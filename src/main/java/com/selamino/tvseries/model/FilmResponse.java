package com.selamino.tvseries.model;

import java.util.Map;

public class FilmResponse {
	
	private boolean success;
	private Map<String, Object> film;
	private String result;
	private String errorCode;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, Object> getFilm() {
		return film;
	}
	public void setFilm(Map<String, Object> film) {
		this.film = film;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
