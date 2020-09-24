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
	 * des : 전체 사용자 조회.
	 */
	@Override
	public List<User> searchAllUsers() {
		return dao.searchAllUsers();
	}
	/*
	 * des : 닉네임으로 사용자 조회.
	 */
	@Override
	public List<User> searchUserbyNickname(String nickname) {
		return dao.searchUserbyNickname(nickname);
	}
	/*
	 * des : ID로 개인 회원 조회.
	 */	
	@Override
	public List<User> searchUserById(String appUserId) {
		return dao.searchUserById(appUserId);
	}
	/*
	 * des : 개인 회원정보 수정.
	 */
	@Override
	public void editUserInfo(String newNickname, String appUserId) {
		dao.editUserInfo(newNickname, appUserId);
	}
	/*
	 * des : 개인회원 제명.
	 */
	@Override
	public void deleteUser(String appUserId) {
		dao.deleteUser(appUserId);
	}	
	
}

