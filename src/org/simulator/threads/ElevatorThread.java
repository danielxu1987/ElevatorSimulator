package org.simulator.threads;

import org.simulator.mainLogic.Building;

// study the sample code from sync producer/consumer
// person on floor 0 and person on floor 1 can be producer and consumer
// and this class is comparable to HoldIntegerSynchronised
// and parameter 'movable' can be patterned after parameter 'writable' 
/** should contain synchronised methods to monitor the call button*/
public class ElevatorThread
{
	private boolean movable;
	
	public ElevatorThread(Building targetBuilding)
	{
		
	}

	public synchronized void callElevator()
	{
		
	}
}
