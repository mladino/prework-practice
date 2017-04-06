package com.northbrook.challenge.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
	
	/**
	 * Format time (hours and minutes) to minutes
	 * @param
	 * @return
	 */
	public static long timeToMinutes(String time){
		//Define 2 groups for regex: 
		//1. "(\\s\\d+)" numbers.  
		//2. "(\\s\\bhour[s]?|\\s\\bmin[s]?)" hour/s or min/s
		String patternstr = "(\\s\\d+)(\\s\\bhour[s]?|\\s\\bmin[s]?|\\s\\bday[s]?)";
	    Pattern pattern = Pattern.compile(patternstr);
	    Matcher matcher = pattern.matcher(time);
	    //counter minutes
	    long minutes = 0;
	    
	    while (matcher.find()) {
		      String value = matcher.group(1);
		      String unit = matcher.group(2);
		      if (unit.contains("hour"))
		    	  //1 hour is 60 minutes
		    	  minutes = minutes + (Long.valueOf(value.trim())*60);
		      else if (unit.contains("day"))
		    	  minutes = minutes + (Long.valueOf(value.trim())*60*24);
		      else
		    	  minutes = minutes + Long.valueOf(value.trim());
		}
		return minutes;
	}

}
