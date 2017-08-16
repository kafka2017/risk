package com.risk.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskController {

	
	@GetMapping(value="/risk/{id}")
	public String risk(@PathVariable String id){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "risk test"+id;
	}
}
