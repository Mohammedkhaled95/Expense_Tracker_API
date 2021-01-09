package com.khaled.expensetracker.exception;

public class UserException extends RuntimeException {

	public UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserException(String arg0) {
		super(arg0);
	}

	public UserException(Throwable arg0) {
		super(arg0);
	}

}
