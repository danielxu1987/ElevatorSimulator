package org.mainLogic;

public class Passenger {

	// attributes
	private String name;
	private int currentFloor;
	private int destinedFloor;
	
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
		return destinedFloor;
	}

	public void setDestinedFloorNumber(int floorNumber) {
		if(currentFloor != floorNumber)
			destinedFloor = floorNumber;
		else
			System.out.println("Passenger " + name + 
					" won't need to move");
	}
	
	// constructors allowing optional input parameters
	public Passenger(String pName, int initialFloor){
		name = pName;
		currentFloor = initialFloor;
		
		System.out.println("Passenger " + name + 
				" just appeared at floor " + currentFloor);
	}
	
	public Passenger(String pName)
	{
		// by default the passenger appears at floor 0
		this(pName, 0);
	}
	
	// actual methods
	// Passenger presses the CallButton
	// a passenger can press the button to call 
	// the elevator which triggers the light 
	// to illuminate and elevator to move 
	public void PressCallButton(){
		String message = "Person " + name + 
				" pressed CallButton at Floor " + currentFloor;
//		return message;
		System.out.println(message);
	}
	
	// Passenger steps into ELevator
	public void StepIntoElevator(){
		// events take place in a sequence
		
//		// first release the CallButton
//		callButton.release();
		String message = "Person " + name + 
				" just stepped into Elevator at Floor " +
				currentFloor;
//		return message;
		System.out.println(message);
	}
	
	// Passenger steps out of Elevator
	public void StepOutOfElevator(){
		String message = "Person " + name + 
				" stepped out of Elevator at Floor "+
				destinedFloor;
//		return message;
		System.out.println(message);
	}
}
