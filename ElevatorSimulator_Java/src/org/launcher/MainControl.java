private package org.launcher;

import org.mainLogic.Building;
import org.mainLogic.Passenger;
import org.simulatorGUI.MainEntry;


// this is control system for elevator and other components
public class MainControl {
	
	// declarations
	
//	public static void main(String[] args)
//	{
////		// Give text output for the elevator system
//		GiveTextMessage();
//		
//		// Initialise the GUI
//		SimulatorGUI simulatorGUI = new SimulatorGUI();
//	}

//	private static void GiveTextMessage() 
//	{
//		// Initialise a building named Office Building
//		// with 2 stories/floors
//		Building buildingA = new Building("Office Building", 2);
//		
//		// for now assume that the person arrives at Floor 0
//		// and wants to go to Floor 1
//		int arrivalFloor = 0;
//		int destinedFloor = 1;
//		
//		// initialise the first person who will use Elevator
//		// assume that he arrives at the ground floor - 0
//		Passenger person1 = new Passenger("Daniel", arrivalFloor);
//		person1.setDestinedFloorNumber(destinedFloor);
//		
//		// The person calls the elevator
//		System.out.println(person1.PressCallButton());
//		
//		// Control system receives the request and asks 
//		// the elevator to move to the floor of calling
//		System.out.println(buildingA.elevator.Moves(arrivalFloor));
//		
//		// Release the CallButton at current Floor once Elevator arrives
//		System.out.println(buildingA.floors[arrivalFloor].callButton.release());
//		
//		// After the elevator door opens, the passenger steps in
//		System.out.println(person1.StepIntoElevator());
//		
//		// Once the elevator door closes elevator moves to the destined Floor
//		System.out.println(buildingA.elevator.Moves(destinedFloor));
//		
//		// Passenger steps out of Elevator
//		System.out.println(person1.StepOutOfElevator());
//		
//		// Set the elevator in standby
//		buildingA.elevator.setIsOccupied(false);
//		System.out.println("Elevator stands by.");
//	}

}

