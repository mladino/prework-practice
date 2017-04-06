package com.northbrook.challenge.transport.strategy;

import java.util.HashMap;
import java.util.Map;

public class TransportModeFactory {
	private static Map<String,TransportMode> instances;
	
	static {
		//Create one strategy for each transport type
		instances = new HashMap<>();
		//Get transport types in enums
		TransportModeEnum[] transportArray = TransportModeEnum.values();
		
		for (int i = 0; i < transportArray.length; i++) {
			final TransportModeEnum transportEnum = transportArray[i];
			//Create strategy
			TransportMode transportMode = new TransportMode() {
				
				@Override
				public long getMilesCapable(long minutes) {
					return (minutes * transportEnum.getVelocityMph())/60;
				}
			};
			//Putting each strategy in static HashMap
			instances.put(transportEnum.getDescription(), transportMode);
		}
		
	}
	
	public static TransportMode get(String mode){
		return instances.get(mode);
	}

}
