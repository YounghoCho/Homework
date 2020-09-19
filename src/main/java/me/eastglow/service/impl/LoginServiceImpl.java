package me.eastglow.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import me.eastglow.dao.LoginDao;
import me.eastglow.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private LoginDao dao;
	
	@Override
	public void insertToken(String authorize_code) throws Exception {
		dao.insertToken(authorize_code);
	}	
}

