package com.yuriybereguliak.moneycache.money;

import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("user_id")
	private int mUserId;
	
	@SerializedName("login")
	private String mLogin;
	
	@SerializedName("first_name")
	private String mFirstName;
	
	@SerializedName("last_name")
	private String mLastName;

	public void setmUserId(int mUserId) {
		this.mUserId = mUserId;
	}

	public void setmLogin(String mLogin) {
		this.mLogin = mLogin;
	}

	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}

	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}
	
	
}
