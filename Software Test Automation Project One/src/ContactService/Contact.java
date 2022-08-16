package ContactService;
//Author Name: Tim Gallus

//Date: 7/17/2022

//Course ID: CS-320-T6631

//Description: Contact object for use with ContactService.


public class Contact {
	
	//Contact attributes.
	private final String contactID; 
	private String firstName; 
	private String lastName; 
	private String phone; 
	private String address;  
	
	//Maximum and required lengths.
	private int contactIDMax = 10;
	private int firstNameMax = 10;
	private int lastNameMax = 10;
	private int phoneRequired = 10;
	private int addressMax = 30;
	
	//Default attribute settings.
	private String defaultFirstName = "NA";
	private String defaultLastName = "NA";
	private String defaultPhone = "0000000000";
	private String defaultAddress = "NA";


	//Contact Constructor for creating a new contact with contactID only.
	//Satisfies object requirements for implementing "The contact service shall be able to add contacts with a unique ID." in ContactService class.
	Contact(String contactID) {
		//Throw exception if contactID is null or exceeds maximum length requirement.
		if(contactID == null || contactID.length() > contactIDMax) {
			throw new IllegalArgumentException("Invalid contactID length or null value");
		}
		
		//Set id based on parameter provided.
		this.contactID = contactID;
		//Set default attributes to default settings.
		this.firstName = defaultFirstName;
		this.lastName = defaultLastName;
		this.phone = defaultPhone;
		this.address = defaultAddress;
	}
	
	//Contact Constructor for a fully fleshed out contact to be entered.  Not a requirement listed in our Milestone Guidelines but probably an overlooked requirement.
	Contact(String contactID, String firstName, String lastName, String phone, String address) {
		//Throw exception if contactID parameter is null or vary from length requirements else set contactID to provided parameter.
		if(contactID == null || contactID.length() > contactIDMax) {
			throw new IllegalArgumentException("Invalid contactID length or null value");
		}
		else {
			this.contactID = contactID;
		}
		//Set attributes to default and raise awareness if parameter provided violates requirements else set attribute to provided parameter.
		if(firstName == null || firstName.length() > firstNameMax) {
			//throw new IllegalArgumentException("Invalid firstName length or null value");
			this.firstName = defaultFirstName;
			System.out.print("First Name provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.firstName = firstName;
		}
		if(lastName == null || lastName.length() > lastNameMax) {
			//throw new IllegalArgumentException("Invalid lastName length or null value");
			this.lastName = defaultLastName;
			System.out.print("Last Name provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.lastName = lastName;
		}
		if(phone == null || phone.length() > phoneRequired) {
			//throw new IllegalArgumentException("Invalid phone length or null value");
			this.phone = defaultPhone;
			System.out.print("Phone provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.phone = phone;
		}
		if(address == null || address.length() > addressMax) {
			//throw new IllegalArgumentException("Invalid firstName length or null value");
			this.address = defaultAddress;
			System.out.print("Address provided does not meet requirements.  Has been set to default value instead.\n");
		}
		else {
			this.address = address;
		}
	}
	
	//Getters for various attributes. 
	protected String getContactID() {
		return this.contactID;
	}
	
	protected String getFirstName() {
		return this.firstName;
	}
	
	protected String getLastName() {
		return this.lastName;
	}
	
	protected String getPhone() {
		return this.phone;
	}
	
	protected String getAddress() {
		return this.address;
	}
	
	//Setters for attributes..  As contactID is not update-able we do not need a setter for it.
	protected void setFirstName(String name) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(name == null || name.length() > firstNameMax) {
			System.out.println("first name parameter violates requirements.  New value not set.");
		}
		else {
			//Set firstName based on provided parameter.
			this.firstName = name;	
		}


	}
	
	protected void setLastName(String name) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(name == null || name.length() > lastNameMax) {
			System.out.println("last name parameter violates requirements.  New value not set.");
		}
		else {
			//Set lastName based on provided parameter.
			this.lastName = name;	
		}


	}
	
	protected void setPhone(String number) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(number == null || number.length() != phoneRequired) {
			System.out.println("phone number parameter violates requirements.  New value not set.");
		}
		else {
			//Set contract phone based on provided parameter.
			this.phone = number;
		}
	}
	
	protected void setAddress(String address) {
		//Do not set attribute if parameter invalid.  Raise awareness of issue.
		if(address == null || address.length() > addressMax) {
			System.out.println("address parameter violates requirements.  New value not set.");
		}
		else {
			//Set contract address based on provided parameter.
			this.address = address;	
		}		
	}

}







