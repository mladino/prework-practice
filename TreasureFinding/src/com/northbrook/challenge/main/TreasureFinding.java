package com.northbrook.challenge.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.northbrook.challenge.model.ResultPrinter;
import com.northbrook.challenge.thread.ThreadsManager;
import com.northbrook.challenge.thread.WorkerThread;

/**
 * Read a file with instructions to find the treasure and calculate distance and direction.
 * The processing of each input instruction is concurrent with 5 threads.
 * @author marcos
 *
 */
public class TreasureFinding {
	
	public static void main(String[] args){
		String fileName = "resources/input.txt";
		 
		 long lineNumber = 0;
		//read de file
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				//Process one line in a thread
				 Runnable worker = new WorkerThread(lineNumber,line);
				 //Init thread on pool
				 ThreadsManager.service.execute(worker);
				 lineNumber++;
			}


		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//If any error has happened
		if (!ThreadsManager.service.isShutdown()){
			//Indicate the pool no accept more task
			ThreadsManager.service.shutdown();
			//Wait until all thread are terminated
			while (!ThreadsManager.service.isTerminated());
		}
		//Print final result
		ResultPrinter.printResult();		
	}
	
	
	

}
