package com.application.TicketMediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.TicketMediator.model.BeanList;
import com.application.TicketMediator.model.Course;
import com.application.TicketMediator.service.CourseService;

@RestController
@RequestMapping("client-api-course")
public class CourseController
{
	@Autowired
	private CourseService service;
	@GetMapping("/getCourses")
	public ResponseEntity<BeanList<Course>> getCourses()
	{
		try {
				return new ResponseEntity<BeanList<Course>>(service.getCourseList(),HttpStatus.OK);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
	}
	@GetMapping("/getPackages")
	public ResponseEntity<BeanList<String>> getPackages()
	{
		try {
				return new ResponseEntity<BeanList<String>>(service.getPackageList(),HttpStatus.OK);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
	}
}
