package com.yuriybereguliak.moneycache.status;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/v1/user")
public class UsersDataSource {

	@GET
	@Path("/me")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public String loadMyProfile() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object obj = parser
					.parse(new FileReader("my_profile_details.json"));
			jsonObject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (jsonObject != null) {
			return jsonObject.toString();
		} else {
			return "{Could not find file}";
		}
	}

	@GET
	@Path("/friends")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public String loadMyFriends() {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = null;
		try {
			Object obj = parser.parse(new FileReader("my_friends.json"));
			jsonArray = (JSONArray) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (jsonArray != null) {
			return jsonArray.toString();
		} else {
			return "{Could not find file}";
		}
	}
}
