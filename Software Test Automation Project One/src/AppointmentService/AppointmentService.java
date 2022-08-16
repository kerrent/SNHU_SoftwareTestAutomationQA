package AppointmentService;
//Author Name: Tim Gallus

//Date: 7/27/2022

//Course ID: CS-320-T6631

//Description: Appointment Service.

import java.util.HashMap;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Date;

public class AppointmentService {

	//Given the uniqueID requirements using a HashMap so we can leverage key value pairing when searching seemed like a good in memory storage option.
	HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	//Display all Appointments in the HashMap (for testing purposes).
	/*
	public void displayAppointmentsHashMap() {
		appointments.entrySet().forEach(entry -> {
			System.out.println("Key: " + entry.getKey() + ", appointmentID: " + entry.getValue().getAppointmentID() + ", Date: "+ entry.getValue().getAppointmentDate() +", Description: " + entry.getValue().getDescription());
		});
	}
	*/
	
	//Method to create a new appointment with only the id for later updating with actual appointment data.  
	public String newAppointmentIDOnly() {
		
		//boolean used for tracking if the key generated is unique or not.
		boolean isUniqueKey = false;
		String uniqueID = null;
		
		//While it is unlikely that we will generate a 10 digit unique code we have already used, we should verify we generated a unique key.
		//A new key will be generated until it is unique to appointments.
		while(!isUniqueKey) {
			//Generate a "unique ID"
			uniqueID = RandomStringUtils.randomAlphanumeric(10);
			
			//Verify the ID is not in use.
			if (appointments == null || !appointments.containsKey(uniqueID)) {
				//Instantiate a new appointment with ID.
				Appointment appointment = new Appointment(uniqueID);
			
				//Add key (our generated uniqueID) and appointment to the hashmap.
				appointments.put(uniqueID, appointment);
				
				//break out of our while loop
				break;
			}
		}
		
		return uniqueID; 
	}
	
	//Method to create a new appointment with all attribute info.
	public String newAppointment(Date date, String description) {
			
			//boolean used for tracking if the key generated is unique or not.
			boolean isUniqueKey = false;
			String uniqueID = null;
			
			//While it is unlikely that we will generate a 10 digit unique code we have already used, we should verify we generated a unique key.
			//A new key will be generated until it is unique
			while(!isUniqueKey) {
				//Generate a "unique ID"
				uniqueID = RandomStringUtils.randomAlphanumeric(10);
				
				//Verify the ID is not in use.
				if (!appointments.containsKey(uniqueID)) {
					
					//Instantiate a new appointment with ID and other attributes..
					Appointment appointment = new Appointment(uniqueID, date, description);
					
					//Add key (our generated uniqueID) and appointment to the hashmap.
					appointments.put(uniqueID, appointment);
					
					//break out of our while loop
					break;
				}
			}	
		return uniqueID; 
	}
	
	//delete appointment from hashmap based on key, which matches appointmentID.
	public void deleteAppointment(String key) {
		appointments.remove(key);
	}
	
	//Update an appointment's date if the date entered meets requirements otherwise raise user awareness of requirement.
	public void updateDate(String key, Date dateInput) {		
		//Update appointment date if date provide current or after else alert user.
		if(dateInput.after(new Date())) {
			appointments.get(key).setAppointmentDate(dateInput);
		}
		else {
			System.out.print("Date entered is prior to current date. Update not performed.");
		}
	}
	
	//Update an appointment's description if the description entered meets length requirements otherwise raise user awareness of requirement.
	public void updateDescription(String key, String description) {
		if(description.length() < 51) {
			appointments.get(key).setDescription(description);
		}
		else {
			System.out.print("Exceeded maximum length.  Description must be 10 characters or less.  Update not performed.");
		}
	}
	
	
}
