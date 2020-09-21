package me.eastglow.service;

import java.util.List;

import me.eastglow.vo.User;

public interface SearchService {
	/*
	 * des : 사용자 조회.
	 */
	public List<User> searchAllUsers();
	public List<User> searchUserbyNickname(String nickname);
	/*
	 * des : 개인 회원 조회.
	 */	
	public List<User> searchUserById(String appUserId);
	
	public void editUserInfo(String newNickname, String appUserId);
	public void deleteUser(String appUserId);
}
