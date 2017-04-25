package com.yuriybereguliak.moneycache.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yuriybereguliak.moneycache.money.Task;

@Path("/v1/status")
public class ApiStatus {

	private static final String apiVersion = "v.1.0";
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTitle() {
		return "Java Web Service";
	}

	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersion() {
		return "Version:" + apiVersion;
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String json(){
		String json = null;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
		Random random = new Random();
		String[] images = {
				"http://icons.iconarchive.com/icons/martz90/circle/512/android-icon.png",
				"http://orig04.deviantart.net/67cd/f/2012/309/8/c/android_icon_by_gabrydesign-d4m7he9.png",
				"https://cdn4.iconfinder.com/data/icons/social-papercut/512/android.png",
				"http://1.bp.blogspot.com/-ZLllok8mx-I/VRDgvP92M6I/AAAAAAAAIJA/7NmT18_AGeo/s1600/ANDROID.png",
				"http://www.iconsdb.com/icons/preview/orange/android-4-xxl.png",
				"http://www.iconsdb.com/icons/preview/orange/android-5-xxl.png",
				"https://elandroidelibre.elespanol.com/wp-content/uploads/2011/07/themechooser.icon_.png"
		};
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		for (int i = 0; i < 30; i++) {
			Task task = new Task();
			task.setTaskId(i);
			task.setTaskTitle("Task #" + i);
			task.setTaskDescription("Task description. Description #" + random.nextInt(1500));
			task.setTaskCreate(new Date());
			task.setImageUri(images[random.nextInt(images.length)]);
			tasks.add(task);
		}
		
		json = gson.toJson(tasks);
		
		return json;
	}
	
	@GET
	@Path("/medical")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public String medical() {
		 JSONParser parser = new JSONParser();
		 JSONObject jsonObject = null;
		 try {
		 Object obj = parser.parse(new FileReader("emergency_format.json"));
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
}
