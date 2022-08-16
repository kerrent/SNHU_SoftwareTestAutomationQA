package ContactService;
//Author Name: Tim Gallus

//Date: 7/17/2022

//Course ID: CS-320-T6631

//Description: Unit Tests for Contact Service.

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

	//Tests for new contacts.
	@Test
	void newContactsTest() {
		ContactService testService = new ContactService();
		
		String testKey1 = testService.newContactIDOnly();
		//Tests for newContactIDOnly
		assertEquals(testService.contacts.size(), 1);
		assertEquals(testService.contacts.get(testKey1).getContactID(), testKey1);
		assertEquals(testService.contacts.get(testKey1).getFirstName(), "NA");
		assertEquals(testService.contacts.get(testKey1).getLastName(), "NA");
		assertEquals(testService.contacts.get(testKey1).getPhone(), "0000000000");
		assertEquals(testService.contacts.get(testKey1).getAddress(), "NA");
		
		
		String testKey2 = testService.newContact("testName1", "testname2", "0123456789", "testAddress");
		//Tests for fully formed new contact.
		assertEquals(testService.contacts.size(), 2);
		assertEquals(testService.contacts.get(testKey2).getContactID(), testKey2);
		assertEquals(testService.contacts.get(testKey2).getFirstName(), "testName1");
		assertEquals(testService.contacts.get(testKey2).getLastName(), "testname2");
		assertEquals(testService.contacts.get(testKey2).getPhone(), "0123456789");
		assertEquals(testService.contacts.get(testKey2).getAddress(), "testAddress");
	}
	
	
	//Tests for deleting contact.
	@Test
	void deleteContactTest() {
		ContactService testService = new ContactService();
		String testKey1 = testService.newContactIDOnly();
		assertTrue(testService.contacts.containsKey(testKey1));
		testService.deleteContact(testKey1);
		assertFalse(testService.contacts.containsKey(testKey1));  //Verify after contact is deleted that it no longer appears in our hashmap after deletion.
	}
	
	
	//Tests for updating first name.
	@Test
	void updateFirstNameTest() {
		ContactService testService = new ContactService();
		String testKey1 = testService.newContactIDOnly();
		assertEquals(testService.contacts.get(testKey1).getFirstName(), "NA");
		testService.updateFirstName(testKey1, "Test1");
		assertEquals(testService.contacts.get(testKey1).getFirstName(), "Test1");
		//Negative Test
		testService.updateFirstName(testKey1, "TestName123");
		assertEquals(testService.contacts.get(testKey1).getFirstName(), "Test1");	
	}
	
	//Tests for updating last name
	@Test
	void updateLastNameTest() {
		ContactService testService = new ContactService();
		String testKey1 = testService.newContactIDOnly();
		assertEquals(testService.contacts.get(testKey1).getLastName(), "NA");
		testService.updateLastName(testKey1, "Test1");
		assertEquals(testService.contacts.get(testKey1).getLastName(), "Test1");
		//Negative Test
		testService.updateLastName(testKey1, "TestName123");
		assertEquals(testService.contacts.get(testKey1).getLastName(), "Test1");	
	}
	
	//Tests for updating phone number
	@Test
	void updatePhoneTest() {
		ContactService testService = new ContactService();
		String testKey1 = testService.newContactIDOnly();
		assertEquals(testService.contacts.get(testKey1).getPhone(), "0000000000");
		testService.updatePhoneNumber(testKey1, "0123456789");
		assertEquals(testService.contacts.get(testKey1).getPhone(), "0123456789");
		//Negative Test
		testService.updatePhoneNumber(testKey1, "TestAddress12345678901234567890");
		assertEquals(testService.contacts.get(testKey1).getPhone(), "0123456789");
	}
	
	//Tests for updating address.
	@Test
	void updateAddressTest() {
		ContactService testService = new ContactService();
		String testKey1 = testService.newContactIDOnly();
		assertEquals(testService.contacts.get(testKey1).getAddress(), "NA");
		testService.updateAddress(testKey1, "Test1");
		assertEquals(testService.contacts.get(testKey1).getAddress(), "Test1");
		//Negative Test
		testService.updateAddress(testKey1, "TestAddress12345678901234567890");
		assertEquals(testService.contacts.get(testKey1).getAddress(), "Test1");
	}
	
	//Negative tests for new contacts.
	@Test
	void newContactsTestNegative() {
		ContactService testService = new ContactService();		
		String testKey1 = testService.newContact("testName123", "testname123", "0123456789011", "TestAddress12345678901234567890");
		//Tests for fully formed new contact.
		assertEquals(testService.contacts.size(), 1);
		assertEquals(testService.contacts.get(testKey1).getContactID(), testKey1);
		assertEquals(testService.contacts.get(testKey1).getFirstName(), "NA");
		assertEquals(testService.contacts.get(testKey1).getLastName(), "NA");
		assertEquals(testService.contacts.get(testKey1).getPhone(), "0000000000");
		assertEquals(testService.contacts.get(testKey1).getAddress(), "NA");
	}
	
}
