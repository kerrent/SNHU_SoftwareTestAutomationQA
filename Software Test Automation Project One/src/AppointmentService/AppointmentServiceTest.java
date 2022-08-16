package AppointmentService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

//Author Name: Tim Gallus

//Date: 7/27/2022

//Course ID: CS-320-T6631

//Description: Unit Tests for Appointment Service.


public class AppointmentServiceTest {

	//Tests for new appointments.
	@Test
	void newAppointmentsTest() {
		AppointmentService testService = new AppointmentService();
		String testKey1 = testService.newAppointmentIDOnly();
		
		//Tomorrows date:
		Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
		
		//Tests for newAppointmentIDOnly
		assertEquals(testService.appointments.size(), 1);
		assertEquals(testService.appointments.get(testKey1).getAppointmentID(), testKey1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(dateFormat.format(testService.appointments.get(testKey1).getAppointmentDate()), dateFormat.format(new Date())); 
		assertEquals(testService.appointments.get(testKey1).getDescription(), "NA");
		
		String testKey2 = testService.newAppointment( tomorrow,"testDescription1");
		//Tests for fully formed new appointment.
		assertEquals(testService.appointments.size(), 2);
		assertEquals(testService.appointments.get(testKey2).getAppointmentID(), testKey2);
		assertEquals(testService.appointments.get(testKey2).getAppointmentDate(), tomorrow);
		assertEquals(testService.appointments.get(testKey2).getDescription(), "testDescription1");
	}
	
	//Tests for deleting appointment.
	@Test
	void deleteAppointmentTest() {
		AppointmentService testService = new AppointmentService();
		String testKey1 = testService.newAppointmentIDOnly();
		
		assertTrue(testService.appointments.containsKey(testKey1));
		testService.deleteAppointment(testKey1);
		assertFalse(testService.appointments.containsKey(testKey1));  //Verify after appointment is deleted that it no longer appears in our hashmap.
	}
	
	//Tests for updating date.
	@Test
	void updateNameTest() {
		AppointmentService testService = new AppointmentService();
		String testKey1 = testService.newAppointmentIDOnly();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(dateFormat.format(testService.appointments.get(testKey1).getAppointmentDate()), dateFormat.format(new Date())); 
		//Tomorrows date.
		Date tomorrow = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));
		testService.updateDate(testKey1, tomorrow);
		assertEquals(testService.appointments.get(testKey1).getAppointmentDate(), tomorrow);
		//Negative Test
		//Yesterday's date.
		Date yesterday = new Date(new Date().getTime() - (1000 * 60 * 60 * 24));
		testService.updateDate(testKey1, yesterday);
		assertEquals(testService.appointments.get(testKey1).getAppointmentDate(), tomorrow);	
	}
	
	//Tests for updating description.
	@Test
	void updateDescriptionTest() {
		AppointmentService testService = new AppointmentService();
		String testKey1 = testService.newAppointmentIDOnly();
		
		assertEquals(testService.appointments.get(testKey1).getDescription(), "NA");
		testService.updateDescription(testKey1, "Test1");
		assertEquals(testService.appointments.get(testKey1).getDescription(), "Test1");
		//Negative Test
		testService.updateDescription(testKey1, "TestDescription1234567890123456789012345678901234567890");
		assertEquals(testService.appointments.get(testKey1).getDescription(), "Test1");	
	}
}
