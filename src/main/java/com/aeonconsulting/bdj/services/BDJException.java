package com.aeonconsulting.bdj.services;

public class BDJException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2219156347261135776L;

	public BDJException(String message) {
		super(message);
	}
	
	public BDJException(Throwable e) {
		super(e);
	}
	
	public BDJException(String message, Throwable e) {
		super(message,e);
	}
}
