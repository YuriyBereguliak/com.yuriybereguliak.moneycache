package com.yuriybereguliak.moneycache.status;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.yuriybereguliak.moneycache.money.Task;

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
