package org.simulatorGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public final class ElevatorControlBoard extends JPanel{
	
	// the circle's diameter is 1/3 of the panel's width
	// and the distance of bounding rectangle to the panel top
	// is 1/4 of the panel's height
	private final int verticalRatio = 4, horizontalRatio = 3;
	
	private final int margin = 3;
	
	private Rectangle buttonFloor0, buttonFloor1;
	
	public ElevatorControlBoard()
	{
		addMouseListener(new MouseClickHandler());
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		InitParameters();
		
		// draw the outline of the bounding envelope - a rectangle
		// whose height is larger than width - so that it can contain
		// 2 circles instead of only 1
		g.setColor(Color.black);
				
		g.drawRect(buttonFloor1.x, buttonFloor1.y, buttonFloor1.width, 
				buttonFloor1.height + buttonFloor0.height + margin);		

		g.setColor(Color.lightGray);
		
		// the circle on the top
		g.fillOval(buttonFloor0.x, buttonFloor0.y, buttonFloor0.width, 
				buttonFloor0.height);
		
		// the circle on the bottom
		g.fillOval(buttonFloor1.x, buttonFloor1.y, buttonFloor1.width, 
				buttonFloor1.height);
	}
	
	private void InitParameters()
	{
		// size of panel at initiating stage
		Dimension size = this.getSize();

		int envelopeHeight, diameter, 
			xUpperLeft, yUpperLeft, ySecondUpperLeft;
		
		// the width of rectangle that bounds 2 circles is only 
		// 1/3 of the width of current panel.		
		diameter = (int) (size.width / horizontalRatio);
		
		// rectangle's height is double of its width plus a bit of margin
		envelopeHeight = diameter * 2 + margin;

		// specify the position of 2 circles and overall bounding rectangle
		xUpperLeft = diameter;
		yUpperLeft = (int) (size.height / verticalRatio);
		ySecondUpperLeft = yUpperLeft + diameter + margin;
		
		// assign two areas representing elevator's floor button to rectangles
		buttonFloor1 = new Rectangle(xUpperLeft, yUpperLeft, diameter, diameter);
		buttonFloor0 = new Rectangle(xUpperLeft, ySecondUpperLeft, diameter, diameter);
	}
	
	
	/** Handle mouse click event which represents pressing elevator's floor buttons*/
	private class MouseClickHandler extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			super.mouseClicked(e);
			
			if(buttonFloor0.contains(e.getX(), e.getY()))
				System.out.println("Passenger pressed floor button 0");
			
			if(buttonFloor1.contains(e.getX(), e.getY()))
				System.out.println("Passenger pressed floor button 1");
		}
	}
}
