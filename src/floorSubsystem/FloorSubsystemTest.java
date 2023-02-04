package floorSubsystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import scheduleServer.Scheduler;

public class FloorSubsystemTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFloorSubsystemInput() {
		FloorSubsystem floorSys = new FloorSubsystem(new Scheduler(), "resources/testinput1.txt", 5);
		
		ArrayList<String> inputTable = floorSys.getInputTable();
		assertTrue(inputTable.size() != 0);
		for (int i = 0; i < inputTable.size(); ++i) {
			assertTrue(inputTable.get(i).matches("^\\d\\d:\\d\\d:\\d\\d\\.\\d+ \\d+ ((Up)|(Down)) \\d+"));
		}
	}
	
	@Test
	public void testFloorSubsystemRun() {
		FloorSubsystem floorSys = new FloorSubsystem(new Scheduler(), "resources/testinput1.txt", 5);
		
		//TODO: figure out how to test this??? maybe this shouldn't be a test idk
		fail("Not yet implemented");
	}

}
