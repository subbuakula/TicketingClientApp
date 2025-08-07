package com.application.TicketMediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.TicketMediator.model.TouristBeanList;
import com.application.TicketMediator.service.TouristService;
import com.application.TicketingMediator.exception.TouristNotfoundException;

@RestController
@RequestMapping(value = "client-api-tourist", produces = MediaType.APPLICATION_JSON_VALUE)
public class TouristController 
{
	@Autowired
	private TouristService service;
	
	@GetMapping(value="/getTouristBetweenBudget/{b1}/{b2}")
	public ResponseEntity<?> getTouristByBudgetBetween(@PathVariable(name = "b1")Double budget1, @PathVariable(name = "b2") Double budget2)
	{
		try
			{
			service.getTouristByBudgetBetween(budget1,budget2).getBody();
			TouristBeanList beanList = (TouristBeanList) service.getTouristByBudgetBetween(budget1,budget2).getBody();
				return new ResponseEntity<TouristBeanList>(beanList,HttpStatus.OK);
			}catch(TouristNotfoundException e)
			{
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping(value = "/getAppStatus")
	public String getAppStatus()
	{
		return service.getAppStatus();
	}

}
