package com.njwb.www.exception;

public class JoyBeanException extends Exception {
	public String errorCode;
	
	public JoyBeanException(String msg,String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public String getMessage(){
		return super.getMessage();
	}
}
