package scheduler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

import floorSubsystem.FloorSubsystem;

public class Scheduler {

	//private ArrayList<FloorSubsystem> fs;
	private LinkedList<FloorRequest> pickupList;
	private LinkedList<PriorityQueue<Integer>> elevatorDropoffUp; // [elevatorNum][nextMove (Sorted)]
	private LinkedList<PriorityQueue<Integer>> elevatorDropoffDown; 
	
	public Scheduler(int numElevators) {
		this.pickupList = new LinkedList<FloorRequest>();
		this.elevatorDropoffUp = new LinkedList<PriorityQueue<Integer>>();
		this.elevatorDropoffDown = new LinkedList<PriorityQueue<Integer>>();
		
		for (int elevNum = 0; elevNum < numElevators; elevNum++) {
			this.elevatorDropoffUp.add(new PriorityQueue<Integer>());
			this.elevatorDropoffDown.add(new PriorityQueue<Integer>());
		}
		
		/* TODO: Start floor subsystems in the run
		for(int floorNum = 0; floorNum < numFloors; floorNum++) {
			fs.add(new FloorSubsystem(this, floorNum));
		}
		*/
	}
	
	public int newFloorRequest(FloorRequest f) {
		//TODO: add error handling
		pickupList.add(f);
		return 0;
	}

	// Returns next floor to move too and adds dropoff to the queue
	public int getWork(int elevatorNum) {
		FloorRequest f = pickupList.poll();
		
		if (f == null || f.getCarButton() == f.getFloor()) {
			return -1;
		}
		
		if (f.getDirection()) { 
			elevatorDropoffUp.get(elevatorNum).add(Integer.valueOf(f.getCarButton()));
		} else {
			elevatorDropoffDown.get(elevatorNum).add(Integer.valueOf(f.getCarButton()));
		}
		
		return f.getFloor();
	}

	//TODO: notify floor of arrival
	public boolean checkForPassengers(int floor, boolean direction) {
		//TODO: refactor
		for (int i = 0; i < pickupList.size(); i++) {
			if (this.pickupList.get(i).getFloor() == floor && this.pickupList.get(i).getDirection() == direction) {
				return true;
			}
		}
		return false;
	}
}
