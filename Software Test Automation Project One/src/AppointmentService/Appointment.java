package AppointmentService;
//Author Name: Tim Gallus

//Date: 7/27/2022

//Course ID: CS-320-T6631

//Description: Appointment object for use with AppointmentService.

import java.util.Date;

public class Appointment {

	//Appointment attributes.
	private final String appointmentID;
	private Date appointmentDate;
	private String description;
	
	//Maximum and required lengths.
	private int appointmentIDMax = 10;
	private int descriptionMax = 50;
	
	//Default attribute settings.
	private String defaultDescription = "NA";
	//Default date is 15 minutes from now.
	private Date defaultAppointmentDate = new Date(new Date().getTime() + (1000*15));
	
	//Appointment Constructor for creating a new appointment with appointmentID only.
	Appointment(String appointmentID) {
		//Throw exception if appointment ID is null or exceeds maximum length requirement.
		if(appointmentID == null || appointmentID.length() > appointmentIDMax) {
			throw new IllegalArgumentException("Invalid appointmentID length or null value");
		}
		//Set id based on parameter provided.
		this.appointmentID = appointmentID;
		//Set default attributes.
		this.appointmentDate = defaultAppointmentDate;
		this.description = defaultDescription;
	}
	
	//Appointment Constructor for a fully fleshed out appointment to be entered.
	Appointment(String appointmentID, Date appointmentDate, String description) {
		//Throw exception if appointmentID parameter is null or vary from length requirements else set appointmentID to provided parameter.
		if(appointmentID == null || appointmentID.length() > appointmentIDMax) {
			throw new IllegalArgumentException("Invalid appointmentID length or null value");
		}
		else {
			this.appointmentID = appointmentID;
		}
		//Set attributes to default and raise awareness if parameter provided violates requirements else set attribute to provided parameter.
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			//throw new IllegalArgumentException("Invalid firstName length or null value");
			this.appointmentDate = defaultAppointmentDate;
			System.out.print("Appointment date provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.appointmentDate = appointmentDate;
		}
		if(description == null || description.length() > descriptionMax) {
			this.description = defaultDescription;
			System.out.print("Description provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.description = description;
		}
	}
	
	//Getters for various attributes.
	protected String getAppointmentID() {
		return this.appointmentID;
	}
		
	protected Date getAppointmentDate() {
		return this.appointmentDate;
	}
		
	protected String getDescription() {
		return this.description;
	}
		
	//Setters for attributes..  As attributeID is not update-able we do not need a setter for it.
	protected void setAppointmentDate(Date appointmentDate) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(appointmentDate == null || appointmentDate.before(new Date())) {
			System.out.println("Appointment date parameter violates requirements.  New value not set.");
		}
		else {
			//Set appointmentDate based on provided parameter.
			this.appointmentDate = appointmentDate;	
		}
	}
	
	protected void setDescription(String description) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(description == null || description.length() > descriptionMax) {
			System.out.println("description parameter violates requirements.  New value not set.");
		}
		else {
			//Set description based on provided parameter.
			this.description = description;	
		}


	}
	
	
}
	
	
	

