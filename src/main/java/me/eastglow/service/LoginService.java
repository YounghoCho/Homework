package me.eastglow.service;

import java.util.List;

import me.eastglow.vo.User;

public interface LoginService {
	/*
	 * des : 카카오 로그인 
	 */
	public String getToken(String authorizeCode) throws Exception;
	public int getUser(String accessToken);
	public int getAppUserDB(int appUserId);	
	public void addUser (String accessToken);
	
	/*
	 * des : 프로필 조회.
	 */
	public List<User> getProfile(String id);
	/*
	 * des : 로그아웃.
	 */
	public void kakaoLogout(String accessToken);
}
