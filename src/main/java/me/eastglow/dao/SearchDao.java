package me.eastglow.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.eastglow.vo.User;

@Repository("SearchDao")
public class SearchDao {
	private static final String NAMESPACE_API = "apiCall.";

	@Autowired
	private SqlSessionTemplate sqlsession;
	/*
	 * des : 전체 사용자 조회.
	 */
	public List<User> searchAllUsers() {
		return sqlsession.selectList(NAMESPACE_API + "searchAllUsers");
	}
	public List<User> searchUserbyNickname(String nickname) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("nickname", nickname);
		return sqlsession.selectList(NAMESPACE_API + "searchUserbyNickname", paramMap);
	}
	/*
	 * des : 개인 회원 조회.
	 */	
	public List<User> searchUserById(String appUserId) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("appUserId", appUserId);
		return sqlsession.selectList(NAMESPACE_API + "searchUserById", paramMap);
	}	
	public void editUserInfo(String newNickname, String appUserId) {
		HashMap<String, Object> paramMap = new HashMap<>();		
		paramMap.put("newNickname", newNickname);
		paramMap.put("appUserId", appUserId);
		sqlsession.insert(NAMESPACE_API + "editUserInfo", paramMap);	
	}
	public void deleteUser(String appUserId) {
		HashMap<String, Object> paramMap = new HashMap<>();		
		paramMap.put("appUserId", appUserId);
		sqlsession.insert(NAMESPACE_API + "deleteUser", paramMap);	
	}
}