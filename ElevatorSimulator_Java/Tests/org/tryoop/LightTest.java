package org.tryoop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mainLogic.Light;

public class LightTest {

	@Test
	public void testLight() {
		Light light1 = new Light();
		
		// by default the just instantiated Light object
		// should be inactive, thus illuminated is false
		assertEquals(false, light1.getIlluminated());
	}

	@Test
	public void testTurnOn() {
		Light light2 = new Light();
		
		// the light must be turned on
		light2.TurnOn();
		assertEquals(true, light2.getIlluminated());
	}

	@Test
	public void testTurnOff() {
		Light light3 = new Light();
		
		// the light must be turned off
		light3.TurnOff();
		assertEquals(false, light3.getIlluminated());
	}
}
