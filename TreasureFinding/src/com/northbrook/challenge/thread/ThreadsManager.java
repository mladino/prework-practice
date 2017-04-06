package com.northbrook.challenge.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsManager {
	//Pool of 5 thread
	public static ExecutorService service = Executors.newFixedThreadPool(5);

}
