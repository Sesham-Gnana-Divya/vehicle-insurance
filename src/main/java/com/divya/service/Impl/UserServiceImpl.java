package com.divya.service.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.divya.model.User;
import com.divya.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class UserServiceImpl implements UserService {

	public int authenticate (String userid, String password) {
		
		try {
			JSONObject jsonObject2 = checkUserId(userid);

			if (jsonObject2 == null)
				return error1;
			else {
				
				if(password.equals(jsonObject2.getString("password")))
					return no_error;
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return error2;
	}
	

	private JSONObject checkUserId(String userid) {
		File jsonFile = new File(filepath);
		Gson gson = new Gson();

		try {

			BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
			for (String line; (line = reader.readLine()) != null;) {
				
				if(line.isBlank())
					continue;
				
				User user = gson.fromJson(line, User.class);
				if (user.getUserid().equals(userid))
				{
					reader.close();
					return new JSONObject(line);
				}
			}
			reader.close();

		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	

	public int save(String userid, String username, String password, String confirm_password) {
		try {
			if(! password.equals(confirm_password))
				return error1;
			
			JSONObject jsonObject2 = checkUserId(userid);
			
			if (jsonObject2 == null) {
				FileWriter writer = new FileWriter(filepath, true);
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("userid", userid);
				jsonObject.put("username", username);
				jsonObject.put("password", password);
				
				writer.write("\n" + jsonObject.toString());
				
				writer.close();
				return no_error;
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			return 10;
		}

		return error2;
	}

	public JSONObject retrieve(String userid) {
		return checkUserId(userid);
	}

	public String remove(String userid, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
