package TaskService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Author Name: Tim Gallus

//Date: 7/21/2022

//Course ID: CS-320-T6631

//Description: Unit tests for Task object.


public class TaskTest {
	
	//Tests for generating a basic Task with no parameters.
	@Test
	void testBasicTask() {
		//Verify we can create a new Task with a valid TaskID.
		Task testTask = new Task("TestID123");
		assertEquals(testTask.getTaskID(),"TestID123");
		//Verify the default attributes were set when the contact was created.
		assertEquals(testTask.getName(),"NA");
		assertEquals(testTask.getDescription(),"NA");
	}

	//Tests for generating a fully formed contact and getters.
	@Test
	void testFullyFormedTask() {
		//Verify we can create a new task with a valid taskID and valid attributes.  Verify all getters return expected data.
		Task testTask = new Task("TestID123", "TestName1", "TestDescription1");
		assertEquals(testTask.getTaskID(), "TestID123");
		assertEquals(testTask.getName(), "TestName1");
		assertEquals(testTask.getDescription(), "TestDescription1");
	}

	//Tests for all setters.  
	@Test
	void testTaskSetters () {
		//Test task for use with testing getters.
		Task testTask = new Task("TestID123");
		//Set the attributes and verify the getters retrieve the new settings.
		testTask.setName("TestName1");
		assertEquals(testTask.getName(), "TestName1");
		testTask.setDescription("TestDescription1");
		assertEquals(testTask.getDescription(), "TestDescription1");
	}
	
	//Negative test for creating a basic task with invalid task id parameter.
	@Test
	void testBasicTaskIDTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901");
		});
	}
	
	//Negative test for creating a basic task with null task id parameter.
	@Test
	void testBasicTaskNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null);
		});
	}
	
	//Negative test set for creating a new fully formed task with invalid taskID.
	@Test
	void testFullyFormedTaskIDTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "TestName1", "TestDescription1");
		});
	}
	
	//Negative test set for creating a new fully formed task with invalid taskID.
	@Test
	void testFullyFormedTaskIDNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "TestName1", "TestDescription1");
		});
	}
	
	
	
	//Negative tests for creating a task with valid id but invalid parameters.
	@Test
	void testFullyFormedTaskInvalidParam () {
		Task testTask = new Task("TestID123", "TestName1234567890123", "TestDescription1234567890123456789012345678901234567890");
		//Verify invalid parameters should be set to default parameters.
		assertEquals(testTask.getName(), "NA");
		assertEquals(testTask.getDescription(), "NA");		
	}
	
	//Negative tests for creating a task with valid id but null parameters.
	@Test
	void testFullyFormedTaskNullParam () {
		Task testTask = new Task("TestID123", null, null);
		//Verify invalid parameters should be set to default parameters.
		assertEquals(testTask.getName(), "NA");
		assertEquals(testTask.getDescription(), "NA");		
	}
	
	
	//Negative Setters tests
	@Test
	void testTaskSettersInvalidParam() {
		Task testTask = new Task("TestID123");
		
		//Verify setting with an unsupported parameter length does not set the attribute.
		testTask.setName("TestName1234567890123");
		assertTrue(testTask.getName().equals("NA"));
		
		testTask.setName(null);
		assertTrue(testTask.getName().equals("NA"));
		
		testTask.setDescription("TestDescription1234567890123456789012345678901234567890");
		assertTrue(testTask.getDescription().equals("NA"));
		
		testTask.setDescription(null);
		assertTrue(testTask.getDescription().equals("NA"));
	}
}
































