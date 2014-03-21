package org.simulatorGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.mainLogic.Building;
import org.mainLogic.Passenger;
import org.simulatorGUI.ClockCanvas;
import org.simulatorGUI.ElevatorCanvas;
import org.simulatorGUI.FloorCanvas;


public class MainEntry extends JFrame
{
	// global variables
	// GUI components
	private final LineBorder bigLine = new 
			LineBorder(Color.black, 2);
	private final LineBorder mediumLine = new 
			LineBorder(Color.black, 1);	
	private ClockCanvas clock;
	private JPanel floorSpace, controlCanvas;
	private FloorCanvas floor1, floor2;
	private ElevatorCanvas elevator;
	private JButton floorButton1, floorButton2;
	private LiftControlBoard liftControlBoard;
	private FloorControlBoard floorControlBoard1,
		floorControlBoard2;
	
	// logic variables
	private static Building building;
	private Passenger passengers[];
	
	
	public static void main(String[] args)
	{
		// initialise everything
		MainEntry launcher = new MainEntry();
	}

	
	public MainEntry()
	{
		super("Elevator Simulator");
		
		// Initialise a building named Office Building
		// then the programme should initialise 2 floors
		// and their gadgets (e.g. light, elevator, doors,
		// call buttons and bells)
		building = new Building("Office Building", 2);
		
//		GiveTextMessage();
		DrawGUIComponents();
	}
	
	private void GiveTextMessage() 
	{		
		// The person calls the elevator
//		System.out.println(person1.PressCallButton());
		
		// Control system receives the request and asks 
		// the elevator to move to the floor of calling
//		System.out.println(building.elevator.Moves(arrivalFloor));
		
		// Release the CallButton at current Floor once Elevator arrives
//		System.out.println(building.floors[arrivalFloor].callButton.release());
		
		// After the elevator door opens, the passenger steps in
//		System.out.println(person1.StepIntoElevator());
		
		// Once the elevator door closes elevator moves to the destined Floor
//		System.out.println(building.elevator.Moves(destinedFloor));
		
		// Passenger steps out of Elevator
//		System.out.println(person1.StepOutOfElevator());
		
		// Set the elevator in standby
//		building.elevator.setIsOccupied(false);
//		System.out.println("Elevator stands by.");
	}

	
	private void DrawGUIComponents()
	{
		// initialise the main container
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5, 5));
		
		Box boxes[] = new Box[2];
		
		// tell the components to lay out horizontally
		// boxes[0] is for the components shown above
		boxes[0] = Box.createHorizontalBox();
		
		// boxes[1] is for the two buttons - Floor1 and Floor2
		boxes[1] = Box.createHorizontalBox();
//		boxes[1].add(Box.createVerticalStrut(40));
		
		// initialise clock canvas
		clock = new ClockCanvas();
		clock.setBorder(bigLine);

		// initialise a floor canvas to hold 2 floors
		floorSpace = new JPanel();
		floorSpace.setLayout(new GridLayout(2, 1));
		floorSpace.setBorder(bigLine);
		
		// initialise 2st floor, on the top
		floor2 = new FloorCanvas();
		floor2.setBorder(mediumLine);
		floorSpace.add(floor2);
		
		// initialise 1st floor, on the bottom
		floor1 = new FloorCanvas();
		floor1.setBorder(mediumLine);
		floorSpace.add(floor1);
		
		// initialise elevator canvas 
		elevator = new ElevatorCanvas();
		elevator.setBorder(bigLine);
		
		// initialise 2 floor control boards and 
		// a elevator control board 
		// initialise control board canvas with 3 rows and 1 column
		controlCanvas = new JPanel(new GridLayout(3, 1));
		controlCanvas.setBorder(bigLine);
		
		// initialise 3 independent drawing regions
		// control board for floor 1 and 2 and elevator
		floorControlBoard1 = new FloorControlBoard();
		floorControlBoard1.setBorder(mediumLine);
		controlCanvas.add(floorControlBoard1);

		liftControlBoard = new LiftControlBoard();
		liftControlBoard.setBorder(mediumLine);
		controlCanvas.add(liftControlBoard);
		
		floorControlBoard2 = new FloorControlBoard();
		floorControlBoard2.setBorder(mediumLine);
		controlCanvas.add(floorControlBoard2);
		
		// the order determines the position of components
		boxes[0].add(clock);
		boxes[0].add(floorSpace);
		boxes[0].add(elevator);
		boxes[0].add(controlCanvas);
		
		// initialise two buttons to be at the bottom - 
		// contained in boxes[1]
		floorButton1 = new JButton("Floor 1");
		floorButton2 = new JButton("Floor 2");
		ButtonHandler bHandler = new ButtonHandler();
		floorButton1.addActionListener(bHandler);
		floorButton2.addActionListener(bHandler);
		
		// give some space to the left of the 1st button
		boxes[1].add(Box.createHorizontalGlue());
		boxes[1].add(floorButton1);
		
		// keep a space in between 2 buttons
		boxes[1].add(Box.createHorizontalGlue());
		boxes[1].add(floorButton2);
		
		// give also space to the right of the 2nd button
		boxes[1].add(Box.createHorizontalGlue());

		c.add(boxes[0], BorderLayout.CENTER);
		c.add(boxes[1], BorderLayout.SOUTH);
		
		setSize(500, 300);
		setVisible(true);

	}
	
	private class ButtonHandler	implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// create a person in the corresponding floor
			Passenger passenger;
			
			if(e.getSource() == floorButton1)
			{
				passenger = new Passenger("Person1");
			}
			
			
			if(e.getSource() == floorButton2)
				passenger = new Passenger("Person2", 1);
			
			// TODO and this 'person' is a thread by itself?
		}

	}

}
