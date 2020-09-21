package me.eastglow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.eastglow.dao.SearchDao;
import me.eastglow.service.SearchService;
import me.eastglow.vo.User;

/*
 * des : 카카오 로그인 
 */
@Service
public class SearchServiceImpl implements SearchService{

	@Resource
	private SearchDao dao;

	@Override
	public List<User> searchAllUsers() {
		return dao.searchAllUsers();
	}

	@Override
	public List<User> searchUserbyNickname(String nickname) {
		return dao.searchUserbyNickname(nickname);
	}	
	
}

