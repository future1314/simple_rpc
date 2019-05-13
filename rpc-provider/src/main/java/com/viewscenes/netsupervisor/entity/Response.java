package com.viewscenes.netsupervisor.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Response  {

	private static final long serialVersionUID = -1023480952777229650L;
	
	private String requestId;
	private int code;
	private String error_msg;
	private Object data;

}
