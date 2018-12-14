package com.yuriybereguliak.moneycache.status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/v1/transfer")
public class JobTransferSession {

	private int mNumberOfStates = 0;

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@GET
	@Path("/GetKicSession")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public String GetKicSession() {
		mNumberOfStates = 0;
		return gson.toJson(new SessionData());
	}


	@GET
	@Path("/GetJobState")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public String GetJobState() {
		mNumberOfStates++;
		if (mNumberOfStates == 5) {
			JobState job = new JobState();
			job.JobState = 1;
			job.FileLink = "k/CUyWDgY5mtS";
			return gson.toJson(job);
		}else {
			return gson.toJson(new JobState();
		}
	}


	@GET
	@Path("/CloseSession")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public void CloseSession() {
		mNumberOfStates = 0;
	}	

	class SessionData {
		long SessionID = 123456789L;
		long ExpirationDate = 123654L;
		String KicId = "KicID";
		String KicVersion = "KicVersion";
		String MyDocsVersion = "MyDocsVersion";
	}

	class JobState {
		long JobId = 12536654L;
		int JobState = 0;
		long LastUpdate = 321654L;
		String FileLink = null;
		String ErrorMessage = null;
		long SessionID = 321654987L;
	}
}
