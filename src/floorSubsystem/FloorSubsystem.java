package floorSubsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

import scheduleServer.*;

public class FloorSubsystem implements Runnable {
	
	private Scheduler scheduler;
	private ArrayList<String> inputTable;
	private ArrayList<Floor> floors;
	
	public FloorSubsystem(Scheduler s, String filepath, int numFloors) {
		
	}
	
	/*
	// TODO maybe synchronize numFloors through scheduler
	public FloorSubsystem(Scheduler scheduler, String filepath, int numFloors) {
		this.scheduler = scheduler;
		inputTable = new ArrayList<>();
		floors = new ArrayList<>();
		
		// Read input file and store in input table
		try {
	      		File inputFile = new File(filepath);
	      		Scanner inputReader = new Scanner(inputFile);
	      		while (inputReader.hasNextLine()) {
				inputTable.add(inputReader.nextLine());
	      		}
		inputReader.close();
	    	} catch (FileNotFoundException e) {
	      		e.printStackTrace();
	    	}
		
		// TODO check if numFloors matches inputfile
		for (int i = 0; i < numFloors; ++i)
			floors.add(new Floor(i+1));
	}

	@Override
	public void run() {
		for (int i = 0; i < inputTable.size(); ++i) {
			// TODO: find a better way to construct Event, maybe in event class
			String[] splitEntry = inputTable.get(i).split("\\s+");
			int[] msgData = {Integer.parseInt(splitEntry[1]), Integer.parseInt(splitEntry[4])};
			
			scheduler.sendEvent(new Event(LocalTime.now(), msgData));
		}
		
		for (int i = 0; i < inputTable.size(); ++i) {
			//Response response = scheduler.getResponse();
			// handle response
		}
	}
	
	// Used for testing
	public ArrayList<String> getInputTable() {
		return inputTable;
	}
	*/
}
