package com.northbrook.challenge.model;

import com.northbrook.challenge.transport.strategy.TransportMode;
import com.northbrook.challenge.transport.strategy.TransportModeFactory;
import com.northbrook.challenge.util.CardinalPoint;

/**
 * Perform processing input
 * @author marcos
 *
 */
public class Instructor {
	
	public static void performDirection(DataInputInstruction input){
		
		TransportMode transportMode = TransportModeFactory.get(input.getMode());
		//Get capability in miles by kind of transport
		long miles = transportMode.getMilesCapable(input.getMinutes());
		//Increment counter
		CardinalPoint.get(input.getDirection()).incrementMilesOnDirection(miles);
	
		
	}

}
