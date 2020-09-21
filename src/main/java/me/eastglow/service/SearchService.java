package me.eastglow.service;

import java.util.List;

import me.eastglow.vo.User;

public interface SearchService {
	/*
	 * des : 사용자 조회.
	 */
	public List<User> searchAllUsers();
	public List<User> searchUserbyNickname(String nickname);
}
