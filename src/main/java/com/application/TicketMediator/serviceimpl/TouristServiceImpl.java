package com.application.TicketMediator.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.TicketMediator.model.TouristBeanList;
import com.application.TicketMediator.service.TouristService;
import com.application.TouristFeignClient.TouristFeignClient;
@Service
public class TouristServiceImpl implements TouristService
{
	@Autowired
	private TouristFeignClient feignClient;

	@Override
	public ResponseEntity<TouristBeanList> getTouristByBudgetBetween(Double budget1, Double budget2) {
		return feignClient.getTouristsBetweenBudget(budget1,budget2);
	}
	
	@Override
	public String getAppStatus()
	{
		String status = feignClient.getAppnStatus();
		return "Application Status: "+ status;
	}
	
}
