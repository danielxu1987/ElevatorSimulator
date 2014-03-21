package org.mainLogic;

public class Floor {
	
	// attributes
	private int floorNumber;
	private int maxCapacity = 1;
	private int currentCapacity = 0;

	// compositions
	public CallButton callButton;
	public Bell bell;
	
	// a FloorDoor may be instantiated later
		
	// methods-getters and setters
	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int anyNumber) {
		this.floorNumber = anyNumber;
	}
	
	public int getMaxCapacity()
	{
		return maxCapacity;
	}
	
	public void setMaxCapacity(int capacity)
	{
		maxCapacity = capacity;
	}
	
	public int getCurrentCapacity()
	{
		return currentCapacity;
	}
	
	public void setCurrentCapacity(int capacityRightNow)
	{
		// make sure the amount of people that come to the floor
		// does not exceed the maxCapacity of this floor
		if(currentCapacity < maxCapacity)
			currentCapacity = capacityRightNow;
		else
			currentCapacity = maxCapacity;
	}

	// constructor
	public Floor(int floorIndex){
		floorNumber = floorIndex;
		System.out.println("floor " + floorNumber + " was just created.");
		
		// initialise the attaching components
		callButton = new CallButton(floorNumber);
		bell = new Bell(floorNumber);
	}
}
