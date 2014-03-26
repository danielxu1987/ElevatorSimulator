package org.simulator.mainLogic;

public class Floor {
	
	// attributes
	private int floorNumber;
	private int maxCapacity = 1;
	private int peopleCount = 0;

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
	
	public int getPeopleCount()
	{
		return peopleCount;
	}
	
	public void setPeopleCount(int peopleCountRightNow)
	{
		// make sure the amount of people that come to the floor
		// does not exceed the maxCapacity of this floor
		if(peopleCount < maxCapacity)
			peopleCount = peopleCountRightNow;
		else
		{
			// when the number people at the floor exceeds the max
			// capacity of that floor a warning will be displayed
			peopleCount = maxCapacity;
			System.out.println("Floor " + floorNumber + 
					" can only contain " + maxCapacity + " people.");
		}
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
