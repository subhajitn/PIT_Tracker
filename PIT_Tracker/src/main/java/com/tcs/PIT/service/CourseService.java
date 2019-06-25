package com.tcs.PIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.PIT.model.Ievolve_Course_Details;
import com.tcs.PIT.repository.CourseRepository;

@Component
public class CourseService {
	@Autowired
	private CourseRepository courseRepo;
	
	public List<Ievolve_Course_Details> findAllCourses(){
		return courseRepo.findAll();
	}
	public Ievolve_Course_Details findCourseById(int id) {
		Optional<Ievolve_Course_Details> course=courseRepo.findById(id);
		if(!course.isPresent()) {
			return null;
		}
		return course.get();
	}
	
	public Ievolve_Course_Details createCourse(Ievolve_Course_Details course) {
		return courseRepo.save(course);
	}
	
}
