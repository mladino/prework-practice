package com.northbrook.challenge.model;

import com.northbrook.challenge.util.CardinalPoint;

/**
 * Encapsulate access to counters and print the final result
 * 
 * @author marcos
 *
 */
public class ResultPrinter {

	private static long counterNorth;
	private static long counterEast;
	private static String errorMessage;

	public static synchronized long getCounterNorth() {
		return counterNorth;
	}

	public static synchronized void addCounterNorth(long miles) {
		ResultPrinter.counterNorth += miles;
	}

	public static synchronized void lessCounterNorth(long miles) {
		ResultPrinter.counterNorth -= miles;
	}

	public static synchronized void lessCounterEast(long miles) {
		ResultPrinter.counterEast -= miles;
	}

	public static synchronized long getCounterEast() {
		return counterEast;
	}

	public static synchronized void addCounterEast(long miles) {
		ResultPrinter.counterEast += miles;
	}

	public static void printResult() {
		if (errorMessage != null)
			System.out.println(errorMessage);
		else {
			if (counterNorth >= 0)
				System.out.print(counterNorth + " miles to the " + CardinalPoint.NORTH.getDescription() + ", ");
			else
				System.out.print(counterNorth * (-1) + " miles to the " + CardinalPoint.SOUTH.getDescription() + ", ");
			if (counterEast >= 0)
				System.out.println(counterEast + " miles to the " + CardinalPoint.EAST.getDescription());
			else
				System.out.println(counterEast * (-1) + " miles to the " + CardinalPoint.WEST.getDescription());
		}

	}

	public static synchronized void setErrorMessage(String errorMessage) {
		ResultPrinter.errorMessage = errorMessage;
	}

}
