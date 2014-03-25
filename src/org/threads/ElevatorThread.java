package org.threads;

import org.mainLogic.Elevator;

public class ElevatorThread extends Thread
{
	public ElevatorThread()
	{
		super();
		
		// initialise a new Elevator object
		Elevator elevator = new Elevator();
	}
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		super.run();
	}
}
