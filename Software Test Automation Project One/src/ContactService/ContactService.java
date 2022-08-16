package ContactService;
//Author Name: Tim Gallus

//Date: 7/17/2022

//Course ID: CS-320-T6631

//Description: Contact Service.


import java.util.HashMap;
import org.apache.commons.lang3.RandomStringUtils;


public class ContactService {

	//Given the uniqueID requirements using a HashMap so we can leverage key value pairing when searching seemed like a good in memory storage option.
	HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	//Display all Contacts in the HashMap (for testing purposes).
	/*
	public void displayContactsHashMap() {
		contacts.entrySet().forEach(entry -> {
			System.out.println("Key: " + entry.getKey() + ", ContractID: " + entry.getValue().getContactID() + ", FirstName: " + entry.getValue().getFirstName() + ", LastName: " + entry.getValue().getLastName() + ", Phone: " + entry.getValue().getPhone() + ", Address: " + entry.getValue().getAddress());
		});
	}
	*/
	
	//Method to create a new contact with only the id for later updating with actual contact data. (meets Milestone Guideline requirement given).  
	public String newContactIDOnly() {
		
		//boolean used for tracking if the key generated is unique or not.
		boolean isUniqueKey = false;
		String uniqueID = null;
		
		//While it is unlikely that we will generate a 10 digit unique code we have already used, we should verify we generated a unique key.
		//A new key will be generated until it is unique to contacts.
		while(!isUniqueKey) {
			//Generate a "unique ID"
			uniqueID = RandomStringUtils.randomAlphanumeric(10);
			
			//Verify the ID is not in use.
			if (contacts == null || !contacts.containsKey(uniqueID)) {
				//Instantiate a new contact with ID.
				Contact contact = new Contact(uniqueID);
			
				//Add key (our generated uniqueID) and contact to the hashmap.
				contacts.put(uniqueID, contact);
				
				//break out of our while loop
				break;
			}
		}
		
		return uniqueID; 
	}
	
	//Method to create a new contact with all attribute info.
	public String newContact(String firstName, String lastName, String phone, String address) {
			
			//boolean used for tracking if the key generated is unique or not.
			boolean isUniqueKey = false;
			String uniqueID = null;
			
			
			//While it is unlikely that we will generate a 10 digit unique code we have already used, we should verify we generated a unique key.
			//A new key will be generated until it is unique
			while(!isUniqueKey) {
				//Generate a "unique ID"
				uniqueID = RandomStringUtils.randomAlphanumeric(10);
				
				//Verify the ID is not in use.
				if (!contacts.containsKey(uniqueID)) {
					
					//Instantiate a new contact with ID and other attributes..
					Contact contact = new Contact(uniqueID, firstName, lastName, phone, address);
					
					//Add key (our generated uniqueID) and contact to the hashmap.
					contacts.put(uniqueID, contact);
					
					//break out of our while loop
					break;
				}
			}
			
			return uniqueID; 
		}
	
	//delete contact from hashmap based on key, which matches contactID.
	public void deleteContact(String key) {
		contacts.remove(key);
	}
	
	//Update a contacts firstName if the name entered meets length requirements otherwise raise user awareness of requirement.
	public void updateFirstName(String key, String name) {
		if(name.length() < 11) {
			contacts.get(key).setFirstName(name);
		}
		else {
			System.out.print("Exceeded maximum length.  First Name must be 10 characters or less.  Update not performed.");
		}
	}
	
	//Update a contacts lastName if the name entered meets length requirements otherwise raise user awareness of requirement.
	public void updateLastName(String key, String name) {
		if(name.length() < 11) {
			contacts.get(key).setLastName(name);
		}
		else {
			System.out.print("Exceeded maximum length.  Last Name must be 10 characters or less.  Update not performed.");
		}
	}
	
	//Update a contacts phone if the phone entered meets length requirements otherwise raise user awareness of requirement.
	public void updatePhoneNumber(String key, String phoneNumber) {
		if(phoneNumber.length() == 10) {
			contacts.get(key).setPhone(phoneNumber);
		}
		else {
			System.out.print("phone number does not match required length.  Phone number must be 10 characters.  Update not performed.");
		}
	}
	
	//Update a contacts address if the address entered meets length requirements otherwise raise user awareness of requirement.
	public void updateAddress(String key, String address) {
		if(address.length() < 31) {
			contacts.get(key).setAddress(address);
		}
		else {
			System.out.print("Exceeded maximum length.  Address must be 30 characters or less.  Update not performed.");
		}
	}
	
	
	
}
