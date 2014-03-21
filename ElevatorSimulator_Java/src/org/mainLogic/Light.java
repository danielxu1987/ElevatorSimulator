package org.mainLogic;

public class Light {

	// indicate if the light is illuminating
	private boolean illuminated;

//	// this is not necessary for now, assumed that
//	// all lights are on from the time passenger has 
//	// pressed the call button to the time it becomes 
//	// free again
	// private int floor;
	
	/* possibly Light object should occur in the 
	 * overall controlling class and not in those 
	 * individual component classes*/
	
	// getters and setters-here a setter is not needed
	public boolean getIlluminated() {
		return illuminated;
	}
	
	// constructor
	public Light(){
		// by default a light is inactive
		illuminated = false;
	}
	
	// actual methods
	
	public void TurnOn(){
		illuminated = true;
		System.out.println("Signal Light was turned on.");
	}
	
	public void TurnOff(){
		illuminated = false;
		System.out.println("Signal Light was turned off.");
	}
}
