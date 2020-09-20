package me.eastglow.service;

public interface LoginService {
	/*
	 * des : 카카오 로그인 
	 */
	public String getToken(String authorizeCode) throws Exception;
	public int getUser(String accessToken);
	public int getAppUserDB(int appUserId);	
	public void addUser (String accessToken);
}
