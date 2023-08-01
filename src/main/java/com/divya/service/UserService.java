package com.divya.service;

import org.codehaus.jettison.json.JSONObject;

import com.divya.service.Impl.UserServiceImpl;
import com.google.inject.ImplementedBy;


@ImplementedBy(UserServiceImpl.class)
public interface UserService {
	final String filepath = "D:\\userdata.JSON";
	final int no_error = 0;
	final int error1 = 1;
	final int error2 = 2;
	
	public int authenticate(String userid, String password);
	public int save(String userid, String username ,String password, String confirm_password);
	public JSONObject retrieve(String userid);
	public String remove(String userid, String password);
}
