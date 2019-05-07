package com.Samina.serviceApplication;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTests {

	@Test
	public void contextLoads() throws Exception {


		 String json =  "[\n" +
				 "{\n" +
				 "    \"firstname\": \"samina--\",\n" +
				 "    \"lastName\": \"Haq\",\n" +
				 "    \"age\": 25\n" +
				 " },\n" +
				 "  {\n" +
				 "    \"firstname\": \"samina\",\n" +
				 "    \"lastName\": \"Haq\",\n" +
				 "    \"age\": 25\n" +
				 "  }\n" + 
				 "]\n";
			 
			 
			 GsonBuilder gsonBuilder = new GsonBuilder();
			 gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
			 Gson gson = gsonBuilder.create();
			 
			 //when
			 JSONWriteExample[] contributors;
			 try (Reader reader = new BufferedReader(new StringReader(json))) {
				 contributors = gson.fromJson(reader, JSONWriteExample[].class);
				 }
				 
				 //then
				 assertThat(contributors).hasSize(2);
				 JSONWriteExample contributor = contributors[0];
				 assertThat(contributor.firstName).isEqualTo("samina");
				 assertThat(contributor.lastName).isEqualTo("Haq");
				}
		}
	

	

