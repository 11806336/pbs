package com.pbs.ams.common.exception;

public class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8895740607382669243L;
	public BaseException() {
	}
	public BaseException(String message){
		super(message);
	}
	public BaseException(Throwable cause){
		super(cause);
	}
	
	public BaseException(String message,Throwable cause){
		super(message, cause);
	}

}
