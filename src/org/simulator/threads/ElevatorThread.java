package org.simulator.threads;

import org.simulator.mainLogic.Building;

// study the sample code from sync producer/consumer
// callbuttons at floor0 and floor1 can be producer and consumer
// and this class is comparable to HoldIntegerSynchronised
// and parameter 'movable' can be a shared memory cell constantly sync
// by callbutton0 and callbutton1. So if callbutton0 wants to call elevator
// which is not free then it should wait until elevator is free. The same 
// with callbutton1
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
