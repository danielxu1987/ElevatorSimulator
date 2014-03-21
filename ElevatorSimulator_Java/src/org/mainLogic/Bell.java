package org.mainLogic;

public class Bell {

	private int floorNumber;
	
	// A floor number is necessary to instantiate 
	// a bell object
	public Bell(int floor){
		floorNumber = floor;
		
		System.out.println("Bell at floor " + 
				floorNumber + " was created.");
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floor) {
		this.floorNumber = floor;
	}
	
	// actual methods
	// Give a signal e.g. sound or text output
	public void ring() {
		System.out.println("Bing!");
	}

}
