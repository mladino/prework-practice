package com.northbrook.challenge.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.northbrook.challenge.model.ResultPrinter;

public enum CardinalPoint {

	NORTH("N","north") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			ResultPrinter.addCounterNorth(miles);
			
		}
	},
	SOUTH("S","south") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			ResultPrinter.lessCounterNorth(miles);;
			
		}
	},
	EAST("E","east") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			ResultPrinter.addCounterEast(miles);
			
		}
	},
	WEST("W","west") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			ResultPrinter.lessCounterEast(miles);
			
		}
	},
	NORTH_EAST("NE","north-east") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			//trunk double to long
			ResultPrinter.addCounterNorth((long)(miles * Math.sin(Math.PI/4)));
			ResultPrinter.addCounterEast((long)(miles * Math.cos(Math.PI/4)));
			
		}
	},
	NORTH_WEST("NW","north-west") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			//trunk double to long
			ResultPrinter.addCounterNorth((long)(miles * Math.sin(Math.PI/4)));
			ResultPrinter.lessCounterEast((long)(miles * Math.cos(Math.PI/4)));
			
		}
	},
	SOUTH_EAST("SE","south-east") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			//trunk double to long
			ResultPrinter.lessCounterNorth((long)(miles * Math.sin(Math.PI/4)));
			ResultPrinter.addCounterEast((long)(miles * Math.cos(Math.PI/4)));
			
		}
	},
	SOUTH_WEST("SW","south-west") {
		@Override
		public void incrementMilesOnDirection(long miles) {
			//trunk double to long
			ResultPrinter.lessCounterNorth((long)(miles * Math.sin(Math.PI/4)));
			ResultPrinter.lessCounterEast((long)(miles * Math.cos(Math.PI/4)));
			
		}
	};
	
	private String name;
	private String description;
	
	public abstract void incrementMilesOnDirection(long miles);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	CardinalPoint(String name, String description){
		this.name = name;
		this.description = description;
	}
	
    private static final Map<String, CardinalPoint> instances = new HashMap<>();

    static {
        for (CardinalPoint cp : EnumSet.allOf(CardinalPoint.class)){
        	instances.put(cp.getName(), cp);
        }
    }
    
    public static CardinalPoint get(String name){
    	return instances.get(name);
    }
}
