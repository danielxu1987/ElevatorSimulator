package org.simulator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.simulator.gui.ClockCanvas;
import org.simulator.gui.ElevatorCanvas;
import org.simulator.gui.FloorCanvas;
import org.simulator.mainLogic.Building;
import org.simulator.mainLogic.Passenger;
import org.simulator.threads.PassengerThread;


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
	private ElevatorControlBoard liftControlBoard;
	private FloorControlBoard floorControlBoard1,
		floorControlBoard2;
	
	// the number of people/passengers at each floor
	// MAYBE not necessary as the floor objects already
	// contain attribute as such
//	private int peopleAtFloor1, peopleAtFloor2;
	
	// logic variables
	
	public Building building;
	
	// people that are in the building now
	// NOTICE: for now the collection type is not important
	private PassengerThread pThread1, pThread2, pThread3;
	private Passenger passengers[] = new Passenger[3];
	
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
		// (by default) and their gadgets (e.g. light, 
		// elevator, doors, call buttons and bells)
		building = new Building("Office Building");
		
		
		System.out.flush();

		Run();
		System.out.flush();
	}
	
	// Run the simulator!
	private void Run()
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
		// TODO initialise the clock thread

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
		// TODO initialise elevator thread
		
		// initialise 2 floor control boards and 
		// a elevator control board 
		// initialise control board canvas with 3 rows and 1 column
		controlCanvas = new JPanel(new GridLayout(3, 1));
		controlCanvas.setBorder(bigLine);
		
		// initialise 3 independent drawing regions
		// control board for floor 1 and 2 and elevator
		floorControlBoard1 = new FloorControlBoard(1);
		floorControlBoard1.setBorder(mediumLine);
		controlCanvas.add(floorControlBoard1);

		liftControlBoard = new ElevatorControlBoard();
		liftControlBoard.setBorder(mediumLine);
		controlCanvas.add(liftControlBoard);
		
		floorControlBoard2 = new FloorControlBoard(0);
		floorControlBoard2.setBorder(mediumLine);
		controlCanvas.add(floorControlBoard2);
		
		// the order determines the position of components
		boxes[0].add(clock);
		boxes[0].add(floorSpace);
		boxes[0].add(elevator);
		boxes[0].add(controlCanvas);
		
		// initialise two buttons to be at the bottom - 
		// geographically contained in boxes[1]
		floorButton1 = new JButton("Floor 1");
		floorButton2 = new JButton("Floor 2");
	
		ButtonHandler bHandler = new ButtonHandler();
		floorButton1.addActionListener(bHandler);
		floorButton2.addActionListener(bHandler);
		// TODO initialise the passenger(s) thread
		
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
		public void actionPerformed(ActionEvent e) 
		{	
			if(e.getSource() == floorButton1)
			{
				// initialise the thread representing passenger
				// at floor 0.
				passengers[0] = new Passenger("Passenger1", 0);

				// instantiate the Person thread
				// assign passenger on floor 0 to this thread
				pThread1 = new PassengerThread(passengers[0], building.elevator);
				
				// add the newly arrived passenger
				building.floors[0].setPeopleCount(1);
				
				// run the passenger thread
//				pThread1.start();
			}
			
			if(e.getSource() == floorButton2)
			{
				// initialise the thread representing passenger
				// at floor 1
				passengers[1] = new Passenger("Passenger2", 1);
				
				// instantiate the thread to be attached by passenger
				// on floor 1
				pThread2 = new PassengerThread(passengers[1], building.elevator);
				
				// add the newly arrived passenger
				// if the amount of people exceeds the max capacity
				// of that floor, don't worry :-) Class Floor is
				// smart enough to handle this.
				building.floors[1].setPeopleCount(1);
				
				// run the passenger thread
//				pThread2.start();
			}
		}
	}


}
