package org.simulator.mainLogic;

public class FloorDoor extends Door {

	public FloorDoor() {
		super("FloorDoor");
	}

	// indicate the floor where this door is installed
	public int floorNumber;

	// methods
	// getters and setters
	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int newFloorNumber) {
		this.floorNumber = newFloorNumber;
	}
	
	/* floor door's opening triggers elevator 
	 method Override is needed here */
}
