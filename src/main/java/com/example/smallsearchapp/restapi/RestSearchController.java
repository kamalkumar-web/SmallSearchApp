package com.example.smallsearchapp.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.smallsearchapp.model.CustomerDetails;
import com.example.smallsearchapp.model.CustomerRepo;

@RestController
public class RestSearchController {

	@Autowired
	CustomerRepo repo;
	
//	@RequestMapping(value = "/getCustomersByCondition", method = RequestMethod.POST)
//	public @ResponseBody String getAllDatasets(@RequestBody MultiValueMap<String, String> userDetails) {
//		System.out.println("Working");
//		System.out.println(userDetails.getFirst("firstName"));
//	    return null; // break point, check model.
//	}
	
	@PostMapping("/getCustomersByCondition")
	public List<CustomerDetails> getCustomerWithCondition(@RequestBody MultiValueMap<String, String> userDetails) {
		System.out.println("called from searchpage for get customer by condition");
		String firstName=userDetails.getFirst("firstName");
		String lastName=userDetails.getFirst("lastName");
		
		if(!firstName.isEmpty() && lastName.isEmpty()) {
			//Data in first Name
//			return repo.findByfirstName(firstName);
			return repo.findByFirstNameCustomized(firstName);
		} else if(firstName.isEmpty() && !lastName.isEmpty()){
			//Data in last Name"
//			return repo.findBylastName(lastName);
			return repo.findByLastNameCustomized(lastName);
		} else if(!firstName.isEmpty() && !lastName.isEmpty()){
			//Data in Both
//			repo.findByFirstN
			return repo.findByFirstAndLastName(firstName,lastName);
		}
		return repo.findAll();
	}
	
	@GetMapping("/getAllCustomers")
	public List<CustomerDetails> getAll() {
		System.out.println("called from searchpage");
		return repo.findAll();
	}
}
