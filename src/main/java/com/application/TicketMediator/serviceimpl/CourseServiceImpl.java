package com.application.TicketMediator.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.TicketMediator.model.BeanList;
import com.application.TicketMediator.model.Course;
import com.application.TicketMediator.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	private static final String REQ_URL = "http://localhost:8080//TicketingApp/course-api/getAllCourses";
	@Autowired
	private RestTemplate template;
	
	@SuppressWarnings("unchecked")
	@Override
	public BeanList<Course> getCourseList() 
	{
		BeanList<Course> courses = null;
		
		try 
		{
//			courses = template.getForObject(REQ_URL, BeanList.class) ;
			ResponseEntity<List<Course>> response = template.exchange(REQ_URL, 
																	  HttpMethod.GET,
																	  null,
																	  new ParameterizedTypeReference<List<Course>>() {});
			List<Course> beanList = response.getBody();
			courses = new BeanList<Course>((ArrayList)beanList);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return courses;
	}

}
