package com.application.TicketMediator.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.application.TicketMediator.model.BeanList;
import com.application.TicketMediator.model.Course;
import com.application.TicketMediator.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService
{
	@Value("${api.base.url}")
	private String BASE_URL;
	@Value("${api.tourists.endpoint.courses}")
	private String COURSE_URL;
	@Value("${api.tourists.endpoint.packages}")
	private String PACK_URL;
	@Autowired
	private RestTemplate template;
	@Autowired
	private WebClient webClient;
	@SuppressWarnings("unchecked")
	@Override
	public BeanList<Course> getCourseList() 
	{
		BeanList<Course> courses = null;
		String url = BASE_URL+COURSE_URL;
		try 
		{
//			courses = template.getForObject(REQ_URL, BeanList.class) ;
			ResponseEntity<List<Course>> response = template.exchange(url, 
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

	@SuppressWarnings("unchecked")
	@Override
	public BeanList<String> getPackageList() 
	{
		String url = BASE_URL+PACK_URL;
		List<String> list = webClient.get()
										   .uri(url)
										   .retrieve()
										   .bodyToMono(List.class)
										   .block();
		BeanList<String> result = new BeanList<String>((ArrayList)list);
		return result;
	}

}
