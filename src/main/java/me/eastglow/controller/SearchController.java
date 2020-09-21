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
	 * des : 전체 유저 검색.
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
}
