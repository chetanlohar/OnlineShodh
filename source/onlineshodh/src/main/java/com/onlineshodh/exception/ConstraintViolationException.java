package com.onlineshodh.exception;

public class ConstraintViolationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private String field;
	
	public ConstraintViolationException(String field,String msg)
	{
		this.setField(field);
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
