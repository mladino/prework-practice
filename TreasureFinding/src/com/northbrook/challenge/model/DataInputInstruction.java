package com.northbrook.challenge.model;

/**
 * Data Transfer Object to encapsulate input data.
 * @author marcos
 *
 */
public class DataInputInstruction {
	
	private String mode;
	private long minutes;
	private String direction;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public long getMinutes() {
		return minutes;
	}
	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public boolean isComplete(){
		return !"".equals(mode) && !"".equals(direction);
	}

}
