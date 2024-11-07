package com.mstfackgz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mstfackgz2.service.MybookListService;

@Controller
public class MyBookListController {
	
	@Autowired
	private MybookListService mybookListService;
	
	@RequestMapping(path = "/deleteMyList/{id}")
	public String deleteMyList(@PathVariable(name = "id")Integer id) {
		mybookListService.deleteById(id);
		return "redirect:/my_books";
	}

}
