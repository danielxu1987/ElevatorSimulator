package org.simulator.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class FloorControlBoard extends JPanel{
	
	private int envelopeLength;
	private final int xyShift = 3;
	private Rectangle buttonArea;
	private int floorButtonCalled;


	public FloorControlBoard(int floor)
	{
		floorButtonCalled = floor;
		
		addMouseListener(new MouseClickHandler());
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		// size of current component
		Dimension size = this.getSize();
	
		// the length of square that bounds the circle is only 
		// 1/3 of the length of current JComponent (e.g. panel)		
		envelopeLength = (int) size.width / 3;
		
		buttonArea = new Rectangle(xyShift + envelopeLength, 
				xyShift + envelopeLength, envelopeLength, envelopeLength);
		
		// draw the outline of the bounding envelope
		g.drawRect(buttonArea.x, buttonArea.y, buttonArea.width, 
				buttonArea.height);		
		
		g.setColor(Color.lightGray);
		
		g.fillOval(buttonArea.x - 1, buttonArea.y - 1, buttonArea.width - 1, 
				buttonArea.height - 1);
	}
	
	/** Handle the PressCallButton behaviour represented by mouse click*/
	private class MouseClickHandler extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			super.mouseClicked(e);
			
			// when the button is clicked
			if(buttonArea.contains(e.getX(), e.getY()))
				System.out.println("CallButton at floor " + 
				floorButtonCalled + " was pressed");
		}
	}
}