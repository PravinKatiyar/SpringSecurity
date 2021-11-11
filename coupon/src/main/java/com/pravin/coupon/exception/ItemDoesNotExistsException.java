package com.pravin.coupon.exception;

public class ItemDoesNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public ItemDoesNotExistsException(String msg) {
		this.msg = msg;
	}
}
