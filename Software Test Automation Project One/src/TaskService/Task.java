package TaskService;
//Author Name: Tim Gallus

//Date: 7/21/2022

//Course ID: CS-320-T6631

//Description: Task object for use with TaskService.

public class Task {

	//Task attributes.
	private final String taskID;
	private String name;
	private String description;
	
	//Attribute maximums.
	private int taskIDMax = 10;
	private int nameMax = 20;
	private int descriptionMax = 50;
	
	//Default attribute settings.
	private String defaultName = "NA";
	private String defaultDescription = "NA";
	
	
	//Task Constructor for creating a new task with taskID only.
	//Satisfies object requirements for implementing "The task service shall be able to add tasks with a unique ID" in TaskService class.
	Task(String taskID) {
		//Throw exception if taskID is null or exceeds maximum length requirement.
		if(taskID == null || taskID.length() > taskIDMax) {
			throw new IllegalArgumentException("Invalid contactID length or null value");
		}
		//Set id based on parameter provided.
		this.taskID = taskID;
		//Set default attributes to default settings.
		this.name = defaultName;
		this.description = defaultDescription;	
	}

	//Task Constructor for a fully fleshed out task to be entered.  Not a requirement listed in our Milestone Guidelines but probably an overlooked requirement.
	Task(String taskID, String name, String description) {
		//Throw exception if taskID is null or exceeds maximum length requirement else set taskID to provided parameter..
		if(taskID == null || taskID.length() > taskIDMax) {
			throw new IllegalArgumentException("Invalid contactID length or null value");
		}
		else {
			this.taskID = taskID;
		}
		//Set attributes to default and raise awareness if parameter provided violates requirements else set attribute to provided parameter.
		if(name == null || name.length() > nameMax) {
			//throw new IllegalArgumentException("Invalid firstName length or null value");
			this.name = defaultName;
			System.out.print("Name provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.name = name;
		}
		if(description == null || description.length() > nameMax) {
			//throw new IllegalArgumentException("Invalid firstName length or null value");
			this.description = defaultDescription;
			System.out.print("Description provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.description = description;
		}
	}

	//Getters for various attributes.
	protected String getTaskID() {
		return this.taskID;
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected String getDescription() {
		return this.description;
	}

	//Setters for attributes..  As taskID is not update-able we do not need a setter for it.
	protected void setName(String name) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(name == null || name.length() > nameMax) {
			System.out.println("name parameter violates requirements.  New value not set.");
		}
		else {
			//Set firstName based on provided parameter.
			this.name = name;	
		}
	}

	protected void setDescription(String description) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(description == null || description.length() > descriptionMax) {
			System.out.println("description parameter violates requirements.  New value not set.");
		}
		else {
			//Set firstName based on provided parameter.
			this.description = description;	
		}
	}


}
