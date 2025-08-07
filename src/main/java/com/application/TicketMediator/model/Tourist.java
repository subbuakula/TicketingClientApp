package com.application.TicketMediator.model;

import lombok.Data;

@Data
public class Tourist
{
		private Integer tid;
		
		private String name;
		private String city;
		private String packageType;
		private Double budget;
}
