package com.northbrook.challenge.util;

import org.junit.Test;
import static org.junit.Assert.*;

import com.northbrook.challenge.util.Helper;

public class HelperTest {
	
	@Test
	public void minutesStringToMinutes(){
		String time = " 20 mins";
		long minutes = Helper.timeToMinutes(time);
		assertEquals(20l, minutes);
	}
	
	@Test
	public void minuteStringToMinutes(){
		String time = " 1 min";
		long minutes = Helper.timeToMinutes(time);
		assertEquals(Long.valueOf(1), Long.valueOf(minutes));
	} 
	
	@Test
	public void hoursStringToMinutes(){
		String time = " 4 hours";
		long minutes = Helper.timeToMinutes(time);
		assertEquals(Long.valueOf(240), Long.valueOf(minutes));
	}
	
	@Test
	public void hourStringToMinutes(){
		String time = " 1 hour";
		long minutes = Helper.timeToMinutes(time);
		assertEquals(60l, minutes);
	}

}
