package com.muzadev.bearertoken.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Meta{

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private List<String> message;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(List<String> message){
		this.message = message;
	}

	public List<String> getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"code = '" + code + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}