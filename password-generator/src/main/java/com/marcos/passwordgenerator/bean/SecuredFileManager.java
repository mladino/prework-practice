package com.marcos.passwordgenerator.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class SecuredFileManager {
	
	public static void get(){
		String fileName = "resources/input.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {

			}


		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void get8(){
		String fileName = "resources/input.txt";
		try(Stream<String> lines = Files.lines(Paths.get(fileName),Charset.defaultCharset())){
				long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
				.distinct()
				.count();
				}
				catch(IOException e){
				}
		
	}

}
