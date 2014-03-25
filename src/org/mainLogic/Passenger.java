package org.mainLogic;

import com.sun.org.apache.regexp.internal.recompile;

public class Passenger {

	// attributes
	private String name;
	private int currentFloor;
	private int destineFloor;
	
	// compositions
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String personsName) {
		this.name = personsName;
	}
	
	public int getCurrentFloorNumber() {
		return currentFloor;
	}

	public void setCurrentFloorNumber(int floorNumber) {
		this.currentFloor = floorNumber;
	}
	
	public int getDestinedFloorNumber() {
		return destineFloor;
	}

	public void setDestinedFloorNumber(int floorNumber) {
		if(currentFloor != floorNumber)
			destineFloor = floorNumber;
		else
			System.out.println("Passenger " + name + 
					" won't need to move");
	}
	
	// constructors allowing optional input parameters
	public Passenger(String pName, int initialFloor){
		name = pName;
		currentFloor = initialFloor;
		
		System.out.println("\nPassenger " + name + 
				" just appeared at floor " + currentFloor);
	}
	
	public Passenger(String pName)
	{
		// by default the passenger appears at floor 0
		this(pName, 0);
	}
	
	// actual methods
	/** a passenger can press the button to call 
	 * the elevator which triggers the light 
	 * to illuminate and elevator to move */
	public void pressCallButton(){
		String message = "Person " + name + 
				" pressed CallButton at Floor " + currentFloor;
//		return message;
		System.out.println(message);
	}
	
	/** Passenger steps into ELevator */
	public void stepIntoElevator(){
		// events take place in a sequence
		
//		// first release the CallButton
//		callButton.release();
		String message = "Person " + name + 
				" just stepped into Elevator at Floor " +
				currentFloor;

		alterFloorNumber();
		
		System.out.println(message);
	}
	
	/** Alter the destine floor*/
	private void alterFloorNumber()
	{
		if(currentFloor == 0)
			destineFloor = 1;
		else if(currentFloor == 1)
			destineFloor = 0;
	}
	
	/** Passenger steps out of Elevator */
	public void stepOutOfElevator(){
		String message = "Person " + name + 
				" stepped out of Elevator at Floor "+
				destineFloor;
//		return message;
		
		// alter the floor where the passenger is at
		alterFloorNumber();
		
		System.out.println(message);
	}
}
