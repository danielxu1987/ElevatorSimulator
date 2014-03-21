package org.simulatorGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public final class FloorControlBoard extends JPanel{
	private int envelopeLength;
	private final int xyShift = 3;
	
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		// size of current component
		Dimension size = this.getSize();
	
		// the length of square that bounds the circle is only 
		// 1/3 of the length of current JComponent (e.g. panel)		
		envelopeLength = (int) size.width / 3;
		
		// draw the outline of the bounding envelope
		g.drawRect(xyShift + envelopeLength, xyShift + envelopeLength, 
				envelopeLength, envelopeLength);		
		
		g.setColor(Color.lightGray);
		
		g.fillOval(xyShift + envelopeLength - 1, 
				xyShift + envelopeLength - 1, envelopeLength - 1, 
				envelopeLength - 1);
	}
}