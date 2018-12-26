package com.newsscrapper.common.exception;

public class ScraperException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errormessage;

	public ScraperException(String errormessage) {
		super();
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}

}
