package me.eastglow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.eastglow.service.impl.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl login;
	
	@RequestMapping(value="/oauth")
	public String login(@RequestParam("code") String code) throws Exception {
	    System.out.println("code : " + code);
	    String accessToken = login.insertToken(code);
	    System.out.println("AccessToken : " + accessToken);
	    return "index";
	}

}
