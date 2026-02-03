package com.cwm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cwm.demo.dto.Coursedto;



@Controller
@RequestMapping("/course/")
public class CourseController {
	
	@GetMapping("/new")
	public String showCreateCourse(Model model) {
		model.addAttribute("courcedto", new Coursedto());
		return "add-course";
	}

	@GetMapping("/list")
	public String listCourses() {
		
		return "courses";
	}
	
	
}
