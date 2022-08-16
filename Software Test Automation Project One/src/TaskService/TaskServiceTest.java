package TaskService;
//Author Name: Tim Gallus

//Date: 7/21/2022

//Course ID: CS-320-T6631

//Description: Unit Tests for Task Service.

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskServiceTest {

	//Tests for new tasks.
	@Test
	void newTasksTest() {
		TaskService testService = new TaskService();
		
		String testKey1 = testService.newTaskIDOnly();
		//Tests for newTaskIDOnly
		assertEquals(testService.tasks.size(), 1);
		assertEquals(testService.tasks.get(testKey1).getTaskID(), testKey1);
		assertEquals(testService.tasks.get(testKey1).getName(), "NA");
		assertEquals(testService.tasks.get(testKey1).getDescription(), "NA");
		
		String testKey2 = testService.newTask("testName1", "testDescription1");
		//Tests for fully formed new task.
		assertEquals(testService.tasks.size(), 2);
		assertEquals(testService.tasks.get(testKey2).getTaskID(), testKey2);
		assertEquals(testService.tasks.get(testKey2).getName(), "testName1");
		assertEquals(testService.tasks.get(testKey2).getDescription(), "testDescription1");
	}
	
	//Tests for deleting task.
	@Test
	void deleteTaskTest() {
		TaskService testService = new TaskService();
		String testKey1 = testService.newTaskIDOnly();
		assertTrue(testService.tasks.containsKey(testKey1));
		testService.deleteTask(testKey1);
		assertFalse(testService.tasks.containsKey(testKey1));  //Verify after task is deleted that it no longer appears in our hashmap after deletion.
	}
	
	//Tests for updating name.
	@Test
	void updateNameTest() {
		TaskService testService = new TaskService();
		
		String testKey1 = testService.newTaskIDOnly();
		assertEquals(testService.tasks.get(testKey1).getName(), "NA");
		testService.updateName(testKey1, "Test1");
		assertEquals(testService.tasks.get(testKey1).getName(), "Test1");
		//Negative Test
		testService.updateName(testKey1, "TestName1234567890123");
		assertEquals(testService.tasks.get(testKey1).getName(), "Test1");	
	}
	
	//Tests for updating description.
	@Test
	void updateDescriptionTest() {
		TaskService testService = new TaskService();
		
		String testKey1 = testService.newTaskIDOnly();
		assertEquals(testService.tasks.get(testKey1).getDescription(), "NA");
		testService.updateDescription(testKey1, "Test1");
		assertEquals(testService.tasks.get(testKey1).getDescription(), "Test1");
		//Negative Test
		testService.updateDescription(testKey1, "TestDescription1234567890123456789012345678901234567890");
		assertEquals(testService.tasks.get(testKey1).getDescription(), "Test1");	
	}
	
	
}
