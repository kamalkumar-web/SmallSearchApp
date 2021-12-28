package com.example.smallsearchapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
	
	@RequestMapping("/search")
	public String searchCustomer() {
		System.out.println("searchpage");
		return "searchpage";
	}
}
