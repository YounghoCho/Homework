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
	
	/*
	 * des :카카오 로그인
	 */
	@RequestMapping(value="/oauth")
	public String login(@RequestParam("code") String code) throws Exception {
		//로그인 버튼 클
	    String accessToken = login.getToken(code);
	    //토큰으로 사용자 조회
	    int appUserId = login.getUser(accessToken);
	    //사용자가 있는지 DB에서 조회
	    int appUserIdDB = login.getAppUserDB(appUserId);	    
  	    //이미 가입된 사용자 사용자정보 페이지로
	    if(appUserId == appUserIdDB) {
	    	System.out.println("이미 등록된 사용자 입니다.");
	    	return "user";
	    }
    	//가입된 사용자가 아니면 자동 회원 가입 후 사용정보 페이지
  	    else {
  	    	System.out.println("아직 등록된 사용자가 아닙니다. 자동 회원가입을 진행합니다.");
  		    login.addUser(accessToken);
  	    }
	    return "user";
	}
}
