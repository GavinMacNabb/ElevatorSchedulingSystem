package scheduler;

import java.util.PriorityQueue;

public class FloorRequest {

	private String time;
	private int floor;
	private boolean direction;
	private int carButton;
	
	public FloorRequest(String time, int floor, boolean direction, int carButton) {
		this.time = time;
		this.floor = floor;
		this.direction = direction;
		this.carButton = carButton;
	}

	public boolean getDirection() {
		return this.direction;
	}

	public int getCarButton() {
		return this.carButton;
	}
	
	public int getFloor() {
		return this.floor;
	}

	
	
}
