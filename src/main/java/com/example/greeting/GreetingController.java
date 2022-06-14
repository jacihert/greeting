package com.example.greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
@RestController
public class GreetingController {
    @Autowired
    GreetingRepository repository;


    @PostMapping("/greeting")
    public String createGreetings(@RequestBody Greeting greeting) {
//        greetings.add(greeting);
    repository.save(greeting);
        return "New Greeting Added" + greeting;
    }

    // DELETE
// make an endpoint "/greeting/{greeting}" that allows us to delete a greeting from the ArrayList greetings

    //	@DeleteMapping("/greeting/{greeting}")
//		public String deleteGreeting(@PathVariable String greeting) {
//		greetings.remove(greeting);
//		return "Greeting Deleted - " + greeting;
//	}

    @DeleteMapping("/greeting/{id}")
    @Transactional
    public String deleteGreeting(@PathVariable String id) {

//        repository.deleteById((parseInt(id)));
        repository.deleteByid(parseInt(id));

        return "Greeting with Id " + id + " has been deleted";
//        for (Greeting greeting:greetings) {
//            if (greeting.getId() == parseInt(id)) {
//                greetings.remove(greeting);
//                return "Greeting  with Id " + greeting.getId() + " has been removed " ;
//            }
//        }
//        return "No greeting with Id " + id + " to delete";

    }

    @GetMapping("/greeting/{id}")
    public Greeting getGreetingById(@PathVariable String id) {
//        public String getGreetingById(@PathVariable String id) {

        List<Greeting> greetings = getGreetings();
        return  greetings.stream()
                .filter(greeting->greeting.getId() ==parseInt(id))
                .findFirst()
                .orElse(null);
//        for (Greeting greeting : greetings ) {
//            if (greeting.getId() == parseInt(id)){
//                return "Here is the greeting with ID: " + id + " greeting " + (greeting.toString());
////				return "Here is the greeting with ID: " + id + " greeting " + (greeting.getGreeting()); // to display only greeting value
            }
//        }
//        return "There is no greeting with ID: " + id;
//    }

    @GetMapping("/greetings")
    public ArrayList<Greeting> getGreetings() {
//		return List.of("Hello", "Howdy", "Hi", "Holla", "Hey", "Hallo", "Whats'up", "Good Day" ,"Have a nice day" ,"Hi ya");
//        return (greetings);
        return (ArrayList<Greeting>) repository.findAll();
    }

//	Challenge
//	make a new "/random" endpoint that gets me a random greeting from a list of greetings
//	hint, you will nee to make an ArrayList that has some greetings already in it

    @GetMapping("/greeting/random")
    public Greeting getRandomGreeting() {
        List<Greeting> greetings = getGreetings();
        int randomIndex = (int) Math.floor(Math.random()* greetings.size());
        return (Greeting) greetings.get(randomIndex);

//        int randomIndex = (int) Math.floor(Math.random()* greetings.size());
//        return greetings.get(randomIndex);
    }


//	http://localhost:8080/
//	@GetMapping("/welcome")
//	public String sayHi() {
//		return "Welcome to the server side!";
//	}

//	// PathVariable (- to just grab a greeting ib id for speed)
//	//	http://localhost:8080/greeting/1
//	@GetMapping("/greeting/{id}")
//	public String getGreetingById(@PathVariable String id) {
//		return "Here is the greeting with ID: " + id;
//	}

//	// RequestParams (- used in instances like Search )
//	// http://localhost:8080/greeting?name=Sam
//	@GetMapping("/greeting")
//	public String getCustomGreeting(@RequestParam String name) {
//		return "Hello " + name;
//	}




}
