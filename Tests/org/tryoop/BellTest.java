package org.tryoop;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mainLogic.Bell;

public class BellTest {

	@Test
	public void testBell() {
		Bell bell1 = new Bell(0);
		assertEquals(0, bell1.getFloorNumber());
	}

	@Test
	public void testSetFloorNumber() {
		Bell bell2 = new Bell(1);
		
		// assign the floor number 2 to this Bell instance
		bell2.setFloorNumber(2);
		
		// then check if the Bell instance is on floor 2
		assertEquals(2, bell2.getFloorNumber());
	}

//	@Test
//	public void testRing() {
//		Bell bell3 = new Bell(2);
//		
//		// assume the signal a Bell gives is 
//		// a text message - "Bing!"
//		assertEquals("Bing!", bell3.ring());
//	}
}
