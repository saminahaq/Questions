package com.Samina.serviceApplication;

//Java program for write JSON to a file 

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map;
import java.util.function.IntPredicate;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 

public class JSONWriteExample 
{ 
	public static final String firstName = "samina";
	public static final String lastName = "Haq";
	public static final int age = 25;

	public static void main(String[] args) throws FileNotFoundException 
	{ 
		// creating JSONObject 
		JSONObject json = new JSONObject(); 
		
		// putting data to JSONObject 
		json.put("firstName", firstName); 
		json.put("lastName", lastName); 
		json.put("age", age); 

		JSONArray jsonarr = new JSONArray(); 
		

		
		PrintWriter pw = new PrintWriter("src/main/resources/JSONExample.json"); 
		pw.write(json.toJSONString()); 
		//InputStream configStream = pw.getClass().getResourceAsStream("JSONExample.json");
		pw.flush(); 
		pw.close(); 
	}


} 
