package com.yf.mvptest.view;

import com.yf.mvptest.R;
import com.yf.mvptest.presenter.UserPresenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class UserActivity extends Activity implements OnClickListener,IUserView {

	private UserPresenter presenter;
	private EditText id,first,last;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
		
		findViewById(R.id.save).setOnClickListener(this);
		findViewById(R.id.load).setOnClickListener(this);
		
		id = (EditText) findViewById(R.id.id);
		first = (EditText) findViewById(R.id.first);
		last = (EditText) findViewById(R.id.last);
		
		presenter = new UserPresenter(this);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.save:
			presenter.saveUser(getID(), getFirstName(), getLastName());
			break;
		case R.id.load:
			presenter.loadUser(getID());
			break;
		default:
			break;
		}
	}

	
}
