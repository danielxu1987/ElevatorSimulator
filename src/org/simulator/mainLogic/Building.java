package org.simulator.mainLogic;

public class Building {
	
	// attributes
	private String name;
	private int maxCapacity;
	
	// compositional elements
	public Floor[] floors;
	public Elevator elevator;
	
	// getters and setters 
	public String getName(){
		return name;
	}
	
	public int getMaxCapacity()
	{
		return maxCapacity;
	}
	
	public void setMaxCapacity(int capacity)
	{
		maxCapacity = capacity;
	}
	
	// constructors
	public Building(String buildingName, int floorCount, int capacity){
		name = buildingName;
		maxCapacity = capacity;
		
		// An Elevator is constructed once 
		// a new Building comes into existence
		elevator = new Elevator();
		
		// Floors are also constructed with the Building
		if(floorCount == 0){
			// this new building has only one floor
			floors = new Floor[1];
			
			// and its the ground floor 0
			floors[0].setFloorNumber(0);
		}
		else if(floorCount > 0){
			floors = new Floor[floorCount];
			
			// a building is constructed from bottom up
			// so floor numbers should ascend
			for(int i = 0; i < floors.length; i++){
				// initialise the floor instance with its number
				floors[i] = new Floor(i);
			}
		}
		
		System.out.println("Building " + name + " was just constructed.");
	}

	public Building(String buildingName, int capacity)
	{
		this(buildingName, 2, capacity);
	}
	
	public Building(String buildingName)
	{
		this(buildingName, 2, 3);
	}

}
