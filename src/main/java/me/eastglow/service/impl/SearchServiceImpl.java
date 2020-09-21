package me.eastglow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.eastglow.dao.SearchDao;
import me.eastglow.service.SearchService;
import me.eastglow.vo.User;

@Service
public class SearchServiceImpl implements SearchService{

	@Resource
	private SearchDao dao;
	/*
	 * des : 사용자 조회.
	 */
	@Override
	public List<User> searchAllUsers() {
		return dao.searchAllUsers();
	}
	@Override
	public List<User> searchUserbyNickname(String nickname) {
		return dao.searchUserbyNickname(nickname);
	}
	/*
	 * des : 개인 회원 조회.
	 */	
	@Override
	public List<User> searchUserById(String appUserId) {
		return dao.searchUserById(appUserId);
	}
	@Override
	public void editUserInfo(String newNickname, String appUserId) {
		dao.editUserInfo(newNickname, appUserId);
	}
	@Override
	public void deleteUser(String appUserId) {
		dao.deleteUser(appUserId);
	}	
	
}

