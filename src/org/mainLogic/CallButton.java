package org.mainLogic;

public class CallButton {
	
	private int floor;
	private boolean pressed;
	
	/* possibly Light object should occur in the 
	 * overall controlling class and not in those 
	 * individual component classes*/
	//private Light light;
	
	// getters and setters
	public boolean getIsPressed()
	{
		return pressed;
	}
	
	// constructor
	public CallButton(int floorNumber)
	{
		floor = floorNumber;
		System.out.println("CallButton at floor " + 
				floor + " was just created.");
	}
	
	// when elevator has departed from the calling floor
	// the call button can be released
	public void release()
	{
		pressed = false;
		System.out.println("CallButton at Floor " + floor + 
				" was released.");
	}
	
	// tell system that the CallButton is pressed
	public void press()
	{
		pressed = true;
		System.out.println("CallButton from floor " + floor +
				" was pressed.");
	}
}
