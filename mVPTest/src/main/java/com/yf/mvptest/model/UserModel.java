package com.yf.mvptest.model;

import com.yf.mvptest.bean.UserBean;

public class UserModel implements IUserModel {

	@Override
	public void setID(int id) {
		// 存储id
	}

	@Override
	public void setFirstName(String firstName) {
		// 存储firstName
		
	}

	@Override
	public void setLastName(String lastName) {
		// 存储lastName
		
	}

	@Override
	public int getID() {
		// 获取id
		return 0;
	}

	@Override
	public UserBean load(int id) {
		// 查数据库或者联网获取id的userbean
		return new UserBean("11", "22");
	}

}
