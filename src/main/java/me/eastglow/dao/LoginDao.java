package me.eastglow.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * des : 카카오 로그인 
 */
@Repository("LoginDao")
public class LoginDao {
	private static final String NAMESPACE_API = "apiCall.";

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	public int getAppUserId(int appUserId) {
		if(sqlsession.selectOne(NAMESPACE_API + "getAppUserId", appUserId) == null) {
			return 0;
		}else {
			return sqlsession.selectOne(NAMESPACE_API + "getAppUserId", appUserId);
		}	
	}
	
	public void addUser(String accessToken, String refreshToken, int appUserId, String nickName) {
		HashMap<String, Object> paramMap = new HashMap<>();		
		paramMap.put("accessToken", accessToken);
		paramMap.put("refreshToken", refreshToken);
		paramMap.put("appUserId", appUserId);
		paramMap.put("nickName", nickName);
		
		sqlsession.insert(NAMESPACE_API + "insertToken", paramMap);	
	}
}