package org.simulator.threads;

import java.util.Random;

import org.simulator.mainLogic.Building;
import org.simulator.mainLogic.Elevator;
import org.simulator.mainLogic.Passenger;

/*		
 * The person calls the elevator
 * Control system receives the request and asks the elevator to 
 * 		move to the floor of calling
 * Release the CallButton at current Floor once Elevator arrives
 * After the elevator door opens, the passenger steps in
 * Once the elevator door closes elevator moves to the destine Floor
 * Passenger steps out of Elevator
 * Set the elevator in standby status
*/
public class PassengerThread extends Thread
{
	private Elevator targetElevator;
	
	private Passenger passenger;
	
	// passenger's movement should be indicated by pressing the GUI button
	private Random willMove;
	
	public PassengerThread(Passenger inputPassenger, Elevator simElevator)
	{
		super(inputPassenger.getName());
		
		passenger = inputPassenger;
		
		targetElevator = simElevator;
		
		willMove = new Random();
	}
	
	/** start the activities a person may take!*/
	@Override
	public void run()
	{
		// generate a random value(true/false)
		// when the passenger wants to 
		// move to the other floor
		if(willMove.nextBoolean())
		{
			passenger.pressCallButton();
			
			// TODO perhaps a thread representing the elevator 
			// should be called here
			if(!targetElevator.getIsOccupied())
			{
				targetElevator.moveTo(passenger.getCurrentFloorNumber());
				passenger.stepIntoElevator();
				int newFloor = passenger.pressElevatorFloorButton();
				targetElevator.moveTo(newFloor);
				passenger.stepOutOfElevator(newFloor);
			}
			else // TODO perhaps the person should 'wait' for the elevator
				System.out.println("Elevator is currently occupied!");
		}
		else
			System.out.println("Passenger doesn't want to move");
	}
}
