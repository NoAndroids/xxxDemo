package com.yf.mvptest.bean;

public class UserBean {

	private String mFirstName;
    private String mLastName;
    
    public UserBean(String mFirstName, String mLastName) {
		super();
		this.mFirstName = mFirstName;
		this.mLastName = mLastName;
	}

	public String getmFirstName() {
		return mFirstName;
	}

	public String getmLastName() {
		return mLastName;
	}
    
	
}
