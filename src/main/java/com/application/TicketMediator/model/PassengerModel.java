package com.application.TicketMediator.model;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class PassengerModel {

	private int pid;
	private String pName;
	private String arrival;
	private String departure;
	private LocalDateTime dateOfJourney;
}
