package com.northbrook.challenge.thread;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.northbrook.challenge.exception.InputDataMissingException;
import com.northbrook.challenge.model.DataInputInstruction;
import com.northbrook.challenge.model.Instructor;
import com.northbrook.challenge.model.ResultPrinter;
import com.northbrook.challenge.util.Helper;

public class WorkerThread implements Runnable {
	 private static final Logger logger = LogManager.getLogManager().getLogger(WorkerThread.class.getName());
	
	private String line;
	private long lineNumber;
	
	public WorkerThread(long lineNumber,String line){
		this.line = line;
		this.lineNumber = lineNumber;
	}

	@Override
	public void run() {
		//read and format each line
		
		DataInputInstruction input;
		try {
			input = readLine(line);

			//calculate distance in each direction (N,S,E,W,NE,NW,SE,SW) and increment counter
			Instructor.performDirection(input);
		} catch (Exception e) {
			String errorMessage = String.format("Error reading line %d: %s", lineNumber,line);
			System.out.println(errorMessage);
			e.printStackTrace();
			ThreadsManager.service.shutdownNow();
			ResultPrinter.setErrorMessage("Calculate the instructions is imposible");
		}
	}

	/**
	 * Read one line from file and put data on DataInputInstruction
	 * @param line
	 * @return
	 * @throws IOException
	 */
	private DataInputInstruction readLine(String line)throws Exception{

		DataInputInstruction input = new DataInputInstruction();
		
			StringTokenizer st = new StringTokenizer(line, ",");
			String mode = (String) st.nextElement();
			String time = (String) st.nextElement();
			String direction =(String) st.nextElement();
			
			input.setMode(mode.trim());
			//convert time to minutes
			input.setMinutes(Helper.timeToMinutes(time));
			input.setDirection(direction.trim());
			if (!input.isComplete())
				throw new InputDataMissingException("Some input data is missing");

		
		return input;
	}
}
