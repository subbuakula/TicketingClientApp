package com.application.TicketMediator.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("hiding")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanList<T> 
{
	private ArrayList<T> beanList;

}
