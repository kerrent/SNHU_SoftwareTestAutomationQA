package ContactService;
//Author Name: Tim Gallus

//Date: 7/17/2022

//Course ID: CS-320-T6631

//Description: Unit tests for Contact object.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	//Tests for generating a basic contact with no parameters.
	@Test
	void testBasicContact() {
		//Verify we can create a new contact with a valid ContactID.
		Contact testContact = new Contact("TestID123");
		assertEquals(testContact.getContactID(),"TestID123");
		//Verify the default attributes were set when the contact was created.
		assertEquals(testContact.getFirstName(),"NA");
		assertEquals(testContact.getLastName(),"NA");
		assertEquals(testContact.getPhone(),"0000000000");
		assertEquals(testContact.getAddress(),"NA");
	}
	
	//Tests for generating a fully formed contact and getters.
	@Test
	void testFullyFormedContact() {
		//Verify we can create a new contact with a valid ContactID and valid attributes.  Verify all getters return expected data.
		Contact testContact = new Contact("TestID123", "TestName1", "TestName2", "1234567890", "TestAddress");
		assertEquals(testContact.getContactID(), "TestID123");
		assertEquals(testContact.getFirstName(), "TestName1");
		assertEquals(testContact.getLastName(), "TestName2");
		assertEquals(testContact.getPhone(), "1234567890");
		assertEquals(testContact.getAddress(), "TestAddress");
	}
	
	//Tests for all setters.  See if you can set up one test contact for all of them to use.
	@Test
	void testContactSetters () {
		//Test contact for use with testing getters.
		Contact testContact = new Contact("TestID123");
		//Set the attributes and verify the getters retrieve the new settings.
		testContact.setFirstName("TestName1");
		assertEquals(testContact.getFirstName(), "TestName1");
		testContact.setLastName("TestName2");
		assertEquals(testContact.getLastName(), "TestName2");
		testContact.setPhone("1234567890");
		assertEquals(testContact.getPhone(), "1234567890");
		testContact.setAddress("TestAddress");
		assertEquals(testContact.getAddress(), "TestAddress");
	}
	
	//Negative test for creating a basic contact with invalid contact id parameter.
	@Test
	void testBasicContactIDTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901");
		});
	}
	
	//Negative test for creating a basic contact with null contact id parameter.
	@Test
	void testBasicContactIDNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null);
		});
	}
	
	
	//Negative test set for creating a new fully formed contact with invalid ContactID.
	@Test
	void testFullyFormedContactIDTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "TestName123", "TestName123", "123456789011", "TestAddress12345678901234567890");
		});
	}
	
	//Negative test set for creating a new fully formed contact with nullContactID.
	@Test
	void testFullyFormedContactIDNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "TestName123", "TestName123", "123456789011", "TestAddress12345678901234567890");
		});
	}
	
	//Negative tests for creating a contact with valid id but invalid parameters.
	@Test
	void testFullyFormedContactInvalidParam () {
		Contact testContact = new Contact("TestID123", "TestName123", "TestName123", "123456789011", "TestAddress12345678901234567890");
		//Verify invalid parameters should be set to default parameters.
		assertEquals(testContact.getFirstName(), "NA");
		assertEquals(testContact.getLastName(), "NA");
		assertEquals(testContact.getPhone(), "0000000000");
		assertEquals(testContact.getAddress(), "NA");
		
	}
	
	//Negative tests for creating a contact with valid id but invalid parameters.
	@Test
	void testFullyFormedContactNullParam () {
		Contact testContact = new Contact("TestID123", null, null, null, null);
		//Verify invalid parameters should be set to default parameters.
		assertEquals(testContact.getFirstName(), "NA");
		assertEquals(testContact.getLastName(), "NA");
		assertEquals(testContact.getPhone(), "0000000000");
		assertEquals(testContact.getAddress(), "NA");
		
	}
	
	//Negative Setters tests
	@Test
	void testContactSettersInvalidParam() {
		Contact testContact = new Contact("TestID123");
		
		//Verify setting with an unsupported parameter length does not set the attribute.
		testContact.setFirstName("TestID12345");
		assertTrue(testContact.getFirstName().equals("NA"));
		
		testContact.setFirstName(null);
		assertTrue(testContact.getFirstName().equals("NA"));
		
		testContact.setLastName("TestID12345");
		assertTrue(testContact.getLastName().equals("NA"));
		
		testContact.setLastName(null);
		assertTrue(testContact.getLastName().equals("NA"));
		
		testContact.setPhone("123456789011");
		assertTrue(testContact.getPhone().equals("0000000000"));
		
		testContact.setPhone(null);
		assertTrue(testContact.getPhone().equals("0000000000"));
		
		testContact.setAddress("TestAddress12345678901234567890");
		assertTrue(testContact.getAddress().equals("NA"));
		
		testContact.setAddress(null);
		assertTrue(testContact.getAddress().equals("NA"));
	}
}
