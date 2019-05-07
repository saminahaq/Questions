package com.samina.consumer;

import java.io.FileReader;
import java.io.IOException;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SpringBootApplication
public class ConsumerApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ConsumerApplication.class, args);

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(
					"/Users/Saminan-Haq/Desktop/Techi-Stuff/test/MAsterCard/Question#04/serviceApplication/src/main/resources/JSONExample.json"));

			JSONObject jsonObject = (JSONObject) obj;

			String firstName = (String) jsonObject.get("firstName");
			String lastName = (String) jsonObject.get("firstName");

			JSONArray jsonObj = (JSONArray) jsonObject.get("Json Objects");

			System.out.println("firstName: " + firstName);
			System.out.println("lastName: " + lastName);

			System.out.println("\nJson Objects:");
			@SuppressWarnings("unchecked")
			Iterator<String> iterator = jsonObj.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
