package com.viewscenes.netsupervisor.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Request  {
	
	private static final long serialVersionUID = 7929047349488932740L;
	
	private String id;
	private String className;// 类名
	private String methodName;// 函数名称
	private Class<?>[] parameterTypes;// 参数类型
	private Object[] parameters;// 参数列表

}
