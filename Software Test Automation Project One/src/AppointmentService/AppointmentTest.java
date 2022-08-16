package AppointmentService;
//Author Name: Tim Gallus

//Date: 7/27/2022

//Course ID: CS-320-T6631

//Description: Unit tests for Appointment object.

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

	//Tests for generating a basic appointment with no parameters.
	@Test
	void testBasicAppointment() {
		//Verify we can create a new Appointment with a valid AppointmentID.
		Appointment testAppointment = new Appointment("TestID123");
		assertEquals(testAppointment.getAppointmentID(),"TestID123");
		//Verify the default attributes were set when the contact was created.
		//compare year month day of appointment date to current year month day.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(dateFormat.format(testAppointment.getAppointmentDate()), dateFormat.format(new Date())); 
		assertEquals(testAppointment.getDescription(),"NA");
	}
	
	//Tests for generating a fully formed appointment and getters.
	@Test
	void testFullyFormedTask() {
		//Tomorrows date.
		Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
	
		//Verify we can create a new appointment with a valid appointmentID and valid attributes.  Verify all getters return expected data
		Appointment testAppointment = new Appointment("TestID123", tomorrow, "TestDescription1");
		assertEquals(testAppointment.getAppointmentID(), "TestID123");
		assertEquals(testAppointment.getAppointmentDate(), tomorrow); 
		assertEquals(testAppointment.getDescription(), "TestDescription1");
	}
	
	//Tests for all setters.  
	@Test
	void testAppointmentSetters () {
		//Tomorrows date.
		Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
		
		//Test appointment for use with testing getters.
		Appointment testAppointment = new Appointment("TestID123");
		//Set the attributes and verify the getters retrieve the new settings.
		testAppointment.setAppointmentDate(tomorrow);
		assertEquals(testAppointment.getAppointmentDate(), tomorrow);
		testAppointment.setDescription("TestDescription1");
		assertEquals(testAppointment.getDescription(), "TestDescription1");
	}
	
	//Negative test for creating a basic appointment with invalid task id parameter.
	@Test
	void testBasicAppointmentIDTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901");
		});
	}
	
	//Negative test for creating a basic appointment with null task id parameter.
	@Test
	void testBasicAppointmentNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null);
		});
	}
	
	//Negative test set for creating a new fully formed appointment with invalid appointmentID.
	@Test
	void testFullyFormedAppointmentIDTooLong () {
		//Tomorrow's date.
		Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", tomorrow, "TestDescription1");
		});
	}
	
	//Negative test set for creating a new fully formed appointment with invalid appointmentID.
	@Test
	void testFullyFormedAppointmentIDNull () {
		//Tomorrow's date.
		Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, tomorrow, "TestDescription1");
		});
	}
	
	//Negative tests for creating a appointment with valid id but invalid parameters.
	@Test
	void testFullyFormedTaskInvalidParam () {
		//Yesterday's date.
		Date yesterday = new Date(new Date().getTime() - (1000 * 60 * 60 * 24));
		
		Appointment testAppointment = new Appointment("TestID123", yesterday, "TestDescription1234567890123456789012345678901234567890");		
		//Verify invalid parameters should be set to default parameters.
		//compare year month day of appointment date, which should be default which is today, to current year month day.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(dateFormat.format(testAppointment.getAppointmentDate()), dateFormat.format(new Date()));
		//assertTrue(testAppointment.getAppointmentDate().before(new Date())); 
		assertEquals(testAppointment.getDescription(), "NA");		
	}
	
	//Negative tests for creating a appointment with valid id but null parameters.
	@Test
	void testFullyFormedAppointmentNullParam () {
		Appointment testAppointment = new Appointment("TestID123", null, null);
		//Verify invalid parameters should be set to default parameters.
		//compare year month day of appointment date, which should be default which is today, to current year month day.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(dateFormat.format(testAppointment.getAppointmentDate()), dateFormat.format(new Date())); 
		assertEquals(testAppointment.getDescription(), "NA");		
	}
	
	//Negative Setters tests
	@Test
	void testSettersInvalidParam() {
		Appointment testAppointment = new Appointment("TestID123");
		
		//Verify setting with an unsupported parameter length does not set the attribute.
		Date yesterday = new Date(new Date().getTime() - (1000 * 60 * 60 * 24));
		testAppointment.setAppointmentDate(yesterday);
		//compare year month day of appointment date, which should be default which is today, to current year month day.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(dateFormat.format(testAppointment.getAppointmentDate()), dateFormat.format(new Date())); 

		testAppointment.setAppointmentDate(null);
		//compare year month day of appointment date, which should be default which is today, to current year month day.
		assertEquals(dateFormat.format(testAppointment.getAppointmentDate()), dateFormat.format(new Date())); 
		
		testAppointment.setDescription("TestDescription1234567890123456789012345678901234567890");
		assertTrue(testAppointment.getDescription().equals("NA"));
		
		testAppointment.setDescription(null);
		assertTrue(testAppointment.getDescription().equals("NA"));
	}	
	
}
