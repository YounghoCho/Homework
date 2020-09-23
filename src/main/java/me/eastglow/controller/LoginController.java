package me.eastglow.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.eastglow.service.impl.LoginServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private LoginServiceImpl login;
	
	/*
	 * des :카카오 로그인
	 */
	@RequestMapping(value="/oauth")
	public String login(@RequestParam("code") String code, HttpSession session) throws Exception {
		//로그인 버튼 클
	    String accessToken = login.getToken(code);
	    //토큰으로 사용자 조회
	    int appUserId = login.getUser(accessToken);
	    //사용자가 있는지 DB에서 조회
	    int appUserIdDB = login.getAppUserDB(appUserId);	    
  	    //이미 가입된 사용자 사용자정보 페이지로
	    if(appUserId == appUserIdDB) {
	    	System.out.println("이미 등록된 사용자 입니다.");
	    }
    	//가입된 사용자가 아니면 자동 회원 가입 후 사용정보 페이지
  	    else {
  	    	System.out.println("아직 등록된 사용자가 아닙니다. 자동 회원가입을 진행합니다.");
  		    login.addUser(accessToken);
  	    }
    	//세션 등록
    	session.setAttribute("userId", appUserId);
    	session.setAttribute("accessToken", accessToken);
    	return "user";
	}
	
	/*
	 * des : 프로필 조회.
	 */
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	@ResponseBody
	public Object getProfile(HttpServletRequest req) throws Exception{
		
		Map<String, Object> result = new HashMap<>();
		result.put("profile", login.getProfile(req.getParameter("id")));
		return result;	
	}
	/*
	 * des : 로그아웃.
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
	    System.out.println("accessToken :" + (String)session.getAttribute("accessToken"));
	    login.kakaoLogout((String)session.getAttribute("accessToken"));
	    session.removeAttribute("accessToken");
	    session.removeAttribute("userId");
	    return "home";
	}
	/*
	 * des : 탈퇴.
	 */
	@RequestMapping(value="/withdraw", method = RequestMethod.POST)
	@ResponseBody
	public int withdrawUser(HttpServletRequest req) throws Exception{
		login.withdrawUser(Integer.parseInt(req.getParameter("appUserId")));
		return 200;
	}	
}
