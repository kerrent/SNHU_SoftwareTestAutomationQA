package TaskService;
//Author Name: Tim Gallus

//Date: 7/21/2022

//Course ID: CS-320-T6631

//Description: Task Service.


import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;

public class TaskService {
	
	//Given the uniqueID requirements using a HashMap so we can leverage key value pairing when searching seemed like a good in memory storage option.
	HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	//Display all Tasks in the HashMap (for testing purposes).
	/*
	public void displayTasksHashMap() {
		tasks.entrySet().forEach(entry -> {
			System.out.println("Key: " + entry.getKey() + ", taskID: " + entry.getValue().getTaskID() + ", FirstName: " + entry.getValue().getName() + ", LastName: " + entry.getValue().getDescription());
		});
	}
	*/
	
	//Method to create a new task with only the id for later updating with actual task data. (meets Milestone Guideline requirement given).  
	public String newTaskIDOnly() {
		
		//boolean used for tracking if the key generated is unique or not.
		boolean isUniqueKey = false;
		String uniqueID = null;
		
		//While it is unlikely that we will generate a 10 digit unique code we have already used, we should verify we generated a unique key.
		//A new key will be generated until it is unique to contacts.
		while(!isUniqueKey) {
			//Generate a "unique ID"
			uniqueID = RandomStringUtils.randomAlphanumeric(10);
			
			//Verify the ID is not in use.
			if (tasks == null || !tasks.containsKey(uniqueID)) {
				//Instantiate a new task with ID.
				Task task = new Task(uniqueID);
			
				//Add key (our generated uniqueID) and task to the hashmap.
				tasks.put(uniqueID, task);
				
				//break out of our while loop
				break;
			}
		}
		
		return uniqueID; 
	}
	
	//Method to create a new task with all attribute info.
	public String newTask(String name, String description) {
			
			//boolean used for tracking if the key generated is unique or not.
			boolean isUniqueKey = false;
			String uniqueID = null;
			
			//While it is unlikely that we will generate a 10 digit unique code we have already used, we should verify we generated a unique key.
			//A new key will be generated until it is unique
			while(!isUniqueKey) {
				//Generate a "unique ID"
				uniqueID = RandomStringUtils.randomAlphanumeric(10);
				
				//Verify the ID is not in use.
				if (!tasks.containsKey(uniqueID)) {
					
					//Instantiate a new task with ID and other attributes..
					Task task = new Task(uniqueID, name, description);
					
					//Add key (our generated uniqueID) and task to the hashmap.
					tasks.put(uniqueID, task);
					
					//break out of our while loop
					break;
				}
			}
			
		return uniqueID; 
	}
	
	//delete task from hashmap based on key, which matches taskID.
	public void deleteTask(String key) {
		tasks.remove(key);
	}
	
	//Update a tasks name if the name entered meets length requirements otherwise raise user awareness of requirement.
	public void updateName(String key, String name) {
		if(name.length() < 21) {
			tasks.get(key).setName(name);
		}
		else {
			System.out.print("Exceeded maximum length.  Name must be 10 characters or less.  Update not performed.");
		}
	}
	
	//Update a tasks description if the description entered meets length requirements otherwise raise user awareness of requirement.
	public void updateDescription(String key, String description) {
		if(description.length() < 51) {
			tasks.get(key).setDescription(description);
		}
		else {
			System.out.print("Exceeded maximum length.  Description must be 10 characters or less.  Update not performed.");
		}
	}		
	
}
















