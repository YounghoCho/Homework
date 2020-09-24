package me.eastglow.service;

import java.util.List;

import me.eastglow.vo.User;

public interface SearchService {
	/*
	 * des : 전체 사용자 조회.
	 */
	public List<User> searchAllUsers();
	/*
	 * des : 닉네임으로 사용자 조회.
	 */
	public List<User> searchUserbyNickname(String nickname);
	/*
	 * des : ID로 개인 회원 조회.
	 */	
	public List<User> searchUserById(String appUserId);
	/*
	 * des : 개인 회원정보 수정.
	 */
	public void editUserInfo(String newNickname, String appUserId);
	/*
	 * des : 개인회원 제명.
	 */
	public void deleteUser(String appUserId);
}
