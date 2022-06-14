package com.example.greeting;


import com.example.greeting.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class GreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

}


//	Path Variable vs RequestParams
//	path variable
//	add additional variable to endpoint ({id})
//		pass annotation to method (can be multiple... in which case just comma separate
//		add parenthesis after annotation if the url variable doesn't match the method argument
//@GetMapping("/greeting/{id}")
//public String getGreetingById(@PathVariable String id) {
//		return "ID: " + id;
//		}
//		request param
//		no need to add a variable to the endpoint
//		pass annotation(s) to method
//		format for hitting this endpoint is http://localhost:8080/greeting?name=Sam
//		for multiple... add another method argument and separate with '&'
//@GetMapping("/greeting")
//public String getCustomGreeting(@RequestParam String name) {
//		return "Hello " + name;
//		}