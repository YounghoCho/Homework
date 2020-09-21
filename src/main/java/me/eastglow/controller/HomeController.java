package me.eastglow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
}