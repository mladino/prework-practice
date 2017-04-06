package com.northbrook.challenge.transport.strategy;

/**
 * Specification of type of transport
 * @author marcos
 *
 */
public interface TransportMode {
	
	public long getMilesCapable(long minutes);
	

}
