package me.eastglow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.eastglow.service.impl.SearchServiceImpl;
import me.eastglow.vo.User;

@RestController
@RequestMapping("/api/")
public class SearchController {
	
	@Autowired
	private SearchServiceImpl search;
	/*
	 * des : 전체 유저 조회.
	 */
	@RequestMapping(value="/users", method = RequestMethod.GET)
	@ResponseBody
	public List<User> searchAllUsers() throws Exception{
		return search.searchAllUsers();
	}
	@RequestMapping(value="/users", method = RequestMethod.GET, params="nickname")
	@ResponseBody
	public List<User> searchUserbyNickname(@RequestParam("nickname") String nickname) throws Exception{
		return search.searchUserbyNickname(nickname);
	}
	/*
	 * des : 개인 회원 조회.
	 */
	@RequestMapping(value="/user", method = RequestMethod.GET)
	@ResponseBody
	public List<User> searchUserById(@RequestParam("appUserId") String appUserId) throws Exception{
		return search.searchUserById(appUserId);
	}
	/*
	 * des : 개인 회원 수정.
	 */
	@RequestMapping(value="/user", method = RequestMethod.PUT)
	@ResponseBody
	public int editUserInfo(@RequestParam("newNickname") String newNickname,
			@RequestParam("appUserId") String appUserId) throws Exception{
		 search.editUserInfo(newNickname, appUserId);
		 return 200;
	}
	/*
	 * des : 개인 회원 삭제.
	 */
	@RequestMapping(value="/user", method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteUser(@RequestParam("appUserId") String appUserId) throws Exception{
		 search.deleteUser(appUserId);
		 return 200;
	}
}
