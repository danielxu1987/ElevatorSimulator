package org.simulator.mainLogic;

public class Elevator {

	// attributes
	
	// indicate if elevator's current in use 
	private boolean isOccupied;
	
	// the boarding floor (may need a range
	// from 0 to max. number of floor)
	private int currentFloor;

	// compositions
	private ElevatorDoor elevatorDoor;

	// constructor
	public Elevator(){
		// by default the elevator stands by
		isOccupied = false;
		currentFloor = 0;
		elevatorDoor = new ElevatorDoor();
		
		System.out.println(
				"Elevator boarding at floor 0 was created.");
	}
	
	// methods
	// getters and setters
	public boolean getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(boolean isBusy) {
		this.isOccupied = isBusy;
		
		// when the elevator is not occupied anymore
		// its door should be closed
		if(!isOccupied){
			closeElevatorDoor();
		}
		
		System.out.println("Elevator was set standby.");
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int newFloor) {
		this.currentFloor = newFloor;
	}
	
	// actual methods (behaviours)
	
	/**the elevator departs and immediately 
	 * (reality simplified) arrives at the floor 
	 * where the passenger is, or where the passenger
	 *  intends to go to. The input is the floor Elevator
	 *  is going to move to*/
	public void moveTo(int destineFloor){
		// several events take place in a sequence
		// assumed that elevator sends direct method 
		// calls to all other components, bell and doors... 
		String message = "";
		
//		message += closeElevatorDoor();
		closeElevatorDoor();
		
		// assumed the movement of elevator from boarding floor
		// to destine floor takes no time
		ArriveAtNewFloor(destineFloor);
		
//		// Bell rings right away, 'Bing!'
//		RingBell();
		
		// after the bell rings elevator door opens
		openElevatorDoor();
		
//		// ...immediately the floor door opens too
//		OpenFloorDoor();
//		return message;
//		System.out.println(message);
	}
	
	/** Change the boarding floor of elevator to the floor
	 *  where passenger's awaiting */
	private void ArriveAtNewFloor(int callingFloor){
		currentFloor = callingFloor;
		
		String message = "Elevator moved to Floor "+ currentFloor +".";
//		return message;
		System.out.println(message);
	}

/*Comments Calls below should be sent by an overall controlling system
 * Ask the bell to ring
//	public void RingBell(){
//		// the alarm to be rung belongs to the arrival floor
//		alarm = new Bell(currentFloor);
//		alarm.ring();
//	}
	
//	// Ask the floor door to open
//	public void OpenFloorDoor(){
//		floorDoor = new FloorDoor();
//		floorDoor.open();
//	}
*/

	/** Ask the ElevatorDoor to open */
	public void openElevatorDoor()
	{
		elevatorDoor.open();
	}
	
	/** Ask the ElevatorDoor to close */
	public void closeElevatorDoor()
	{
		elevatorDoor.close();
	}
}
