package com.yuriybereguliak.moneycache.status;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
		ArrayList<Task> tasks = new ArrayList<Task>();
		for (int i = 0; i < 30; i++) {
			Task task = new Task();
			task.setTaskId(i);
			task.setTaskTitle("Task #" + i);
			task.setTaskDescription("Task description. Description #" + i);
			task.setTaskCreate(new Date());
			tasks.add(task);
		}
		
		json = gson.toJson(tasks);
		
		return json;
	}
	

}
