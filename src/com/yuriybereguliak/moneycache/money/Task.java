package com.yuriybereguliak.moneycache.money;

import java.util.Date;

public class Task {

	@SuppressWarnings("unused")
	private int taskId;
	@SuppressWarnings("unused")
	private String taskTitle;
	@SuppressWarnings("unused")
	private String taskDescription;
	@SuppressWarnings("unused")
	private int taskRating;
	@SuppressWarnings("unused")
	private Date taskCreate;
	
	/**
	 *  Default constructor
	 */
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public void setTaskRating(int taskRating) {
		this.taskRating = taskRating;
	}

	public void setTaskCreate(Date taskCreate) {
		this.taskCreate = taskCreate;
	}

	
}
