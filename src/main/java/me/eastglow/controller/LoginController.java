package me.eastglow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value="/oauth")
	public String login(@RequestParam("code") String code) {
	    System.out.println("code : " + code);
	    return "index";
	}

}
