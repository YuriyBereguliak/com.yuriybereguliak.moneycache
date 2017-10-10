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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/v1/user")
public class UsersDataSource {

	@GET
	@Path("/me")
	@Produces(MediaType.APPLICATION_JSON)
	public String medical() {
		 JSONParser parser = new JSONParser();
		 try {
		 Object obj = parser.parse(new FileReader("my_profile_details.json"));
         JSONObject jsonObject = (JSONObject) obj;
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		return jsonObject;
	}
	
	@GET
	@Path("/friends")
	@Produces(MediaType.APPLICATION_JSON)
	public String medical() {
		 JSONParser parser = new JSONParser();
		 try {
		 Object obj = parser.parse(new FileReader("my_friends.json"));
         JSONObject jsonObject = (JSONObject) obj;
		 } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		return jsonObject;
	}
}
