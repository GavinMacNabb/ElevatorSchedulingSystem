package scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

public class SchedulerTest {
	
	//The Floor subsystem is to read in events using the format shown above: 
	//Time, floor or elevator number, and button. 
	//Each line of input is to be sent to the Scheduler.
	@Test
	public void newFloorRequest() {
		Scheduler s = new Scheduler(0);
		
		String time = "01:00:00.000";
		int floor = 2;
		int carButton = 4;
		boolean direction = (carButton >= floor) ? true : false;
		
		FloorRequest p = new FloorRequest(time, floor, direction, carButton);
		
		int err = s.newFloorRequest(p);
		
		assertTrue(err == 0);
	}

	//The elevators will make calls to the Scheduler which will then reply when there is work to be done. 
	//The Elevator will then send the data back to the Scheduler who will then send it back to the Floor
	@Test
	public void getWorkUp() {
		Scheduler s = new Scheduler(1);
		
		String time = "01:00:00.000";
		int floor = 2;
		int carButton = 4;
		boolean direction = (carButton >= floor) ? true : false;
		
		FloorRequest p = new FloorRequest(time, floor, direction, carButton);
		
		int err = s.newFloorRequest(p);
		
		assertTrue(err == 0);
		
		int elevatorNum = 0;
		
		int response = s.getWork(elevatorNum);
		
		assertTrue(response == floor);
	}
	
	//The elevators will make calls to the Scheduler which will then reply when there is work to be done. 
	//The Elevator will then send the data back to the Scheduler who will then send it back to the Floor
	@Test
	public void getWorkDown() {
		Scheduler s = new Scheduler(1);
		
		String time = "01:00:00.000";
		int floor = 4;
		int carButton = 2;
		boolean direction = (carButton >= floor) ? true : false;
		
		FloorRequest p = new FloorRequest(time, floor, direction, carButton);
		
		int err = s.newFloorRequest(p);
		
		assertTrue(err == 0);
		
		int elevatorNum = 0;
		
		int response = s.getWork(elevatorNum);
		
		assertTrue(response == floor);
	}
	
	//The elevators will make calls to the Scheduler which will then reply when there is work to be done. 
	//The Elevator will then send the data back to the Scheduler who will then send it back to the Floor
	@Test
	public void getWorkError() {
		Scheduler s = new Scheduler(1);
		
		String time = "01:00:00.000";
		int floor = 2;
		int carButton = 2;
		boolean direction = (carButton >= floor) ? true : false;
		
		FloorRequest p = new FloorRequest(time, floor, direction, carButton);
		
		int err = s.newFloorRequest(p);
		
		assertTrue(err == 0);
		
		int elevatorNum = 0;
		
		int response = s.getWork(elevatorNum);
		
		assertTrue(response == -1);
	}
	
	@Test
	public void checkForPassengers() {
		Scheduler s = new Scheduler(1);
	
		String time = "01:00:00.000";
		int floor = 2;
		int carButton = 4;
		boolean direction = (carButton >= floor) ? true : false;
		
		FloorRequest p = new FloorRequest(time, floor, direction, carButton);
		
		s.newFloorRequest(p);
		
		boolean hasPassengers = s.checkForPassengers(floor, direction);
		System.out.println(hasPassengers);
		
		assertTrue(hasPassengers == true);
	}
	
}
