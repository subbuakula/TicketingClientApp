package com.application.TouristFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.TicketMediator.model.TouristBeanList;

@FeignClient(name="TICKETINGAPP")
public interface TouristFeignClient 
{
	@GetMapping(value = "/TicketingApp/api/getTouristsBetweenBudget/{budget1}/{budget2}")//, produces = {"application/xml","application/json"})
	public ResponseEntity<TouristBeanList>getTouristsBetweenBudget(@PathVariable("budget1") Double budget1,@PathVariable("budget2") Double budget2);

	@GetMapping(value = "/TicketingApp/api/getAppStatus")
	public String getAppnStatus();
}
