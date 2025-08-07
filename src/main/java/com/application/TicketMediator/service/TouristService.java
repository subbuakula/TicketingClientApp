package com.application.TicketMediator.service;

import org.springframework.http.ResponseEntity;

import com.application.TicketMediator.model.TouristBeanList;

public interface TouristService 
{
	public ResponseEntity<TouristBeanList> getTouristByBudgetBetween(Double budget1, Double budget2);

	public String getAppStatus();
}
