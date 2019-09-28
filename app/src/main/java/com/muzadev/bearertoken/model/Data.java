package com.muzadev.bearertoken.model;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("id")
	private String id;

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"access_token = '" + accessToken + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}