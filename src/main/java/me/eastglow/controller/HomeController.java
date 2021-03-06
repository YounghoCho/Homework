package me.eastglow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping(value="/user")
	public ModelAndView goUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		return mv;
	}
	@RequestMapping(value="/search")
	public ModelAndView goSearch() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search");
		return mv;
	}
	@RequestMapping(value="/person")
	public ModelAndView goPerson() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("person");
		return mv;
	}
}