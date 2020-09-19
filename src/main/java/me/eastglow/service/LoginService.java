package me.eastglow.service;

public interface LoginService {
	public String insertToken(String authorize_code) throws Exception;
}
