package com.yf.mvptest.presenter;

import com.yf.mvptest.bean.UserBean;
import com.yf.mvptest.model.IUserModel;
import com.yf.mvptest.model.UserModel;
import com.yf.mvptest.view.IUserView;

/**
 * Presenter就能通过接口与View及Model进行交互
 * @author Administrator
 *
 */
public class UserPresenter {

	private IUserView mUserView;
    private IUserModel mUserModel;
    
    
	public UserPresenter(IUserView mUserView) {
		super();
		this.mUserView = mUserView;
		mUserModel = new UserModel();
	}
    
	public void saveUser(int id,String firstName,String lastName) {
		mUserModel.setID(id);
		mUserModel.setFirstName(firstName);
		mUserModel.setLastName(lastName);
	}
	
	public void loadUser(int id) {
		UserBean userBean = mUserModel.load(id);
		mUserView.setFirstName(userBean.getmFirstName());  // 通过调用IUserView的方法来更新显示
		mUserView.setLastName(userBean.getmLastName());
	}
    
}
