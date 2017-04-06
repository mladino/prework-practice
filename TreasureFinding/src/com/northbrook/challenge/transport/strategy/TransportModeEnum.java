package com.northbrook.challenge.transport.strategy;

public enum TransportModeEnum {
	
	WALK("Walk",3),
	RUN("Run",6),
	HORSE_TROT("Horse trot",4),
	HORSE_GALLOP("Horse gallop",15),
	ELEPHANT_RIDE("Elephant ride",6);
	
	private final String description;
	private final int velocityMph;
	
	TransportModeEnum(String description, int velocityMph){
		this.description = description;
		this.velocityMph = velocityMph;
	}

	public String getDescription() {
		return description;
	}

	public int getVelocityMph() {
		return velocityMph;
	}

}
