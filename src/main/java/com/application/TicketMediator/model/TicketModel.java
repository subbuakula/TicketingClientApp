package com.application.TicketMediator.model;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class TicketModel 
{
	private Integer ticketNo;
	private String status;
	private Double ticketCost;
	private String name;
	private String arrival;
	private String departure;
	private LocalDateTime dateOfJourney;
	

}
