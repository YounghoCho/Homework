package me.eastglow.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.eastglow.vo.User;

/*
 * des : 카카오 로그인 
 */
@Repository("LoginDao")
public class LoginDao {
	private static final String NAMESPACE_API = "apiCall.";

	@Autowired
	private SqlSessionTemplate sqlsession;
	/*
	 * des : 유저 가입 여부 검사. 
	 */
	public int getAppUserId(int appUserId) {
		if(sqlsession.selectOne(NAMESPACE_API + "getAppUserId", appUserId) == null) {
			return 0;
		}else {
			return sqlsession.selectOne(NAMESPACE_API + "getAppUserId", appUserId);
		}	
	}
	/*
	 * des : 유저 신규 가입.
	 */
	public void addUser(String accessToken, String refreshToken, int appUserId, String nickName) {
		HashMap<String, Object> paramMap = new HashMap<>();		
		paramMap.put("accessToken", accessToken);
		paramMap.put("refreshToken", refreshToken);
		paramMap.put("appUserId", appUserId);
		paramMap.put("nickName", nickName);
		
		sqlsession.insert(NAMESPACE_API + "insertToken", paramMap);	
	}
	
	/*
	 * des : 프로필 조회.
	 */
	public List<User> getProfile(String id) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		return sqlsession.selectList(NAMESPACE_API + "getProfile", paramMap);
	}
	/*
	 * des : 회원 탈퇴.
	 */
	public void withdrawUser(int appUserId) {
		HashMap<String, Object> paramMap = new HashMap<>();		
		paramMap.put("appUserId", appUserId);		
		sqlsession.insert(NAMESPACE_API + "withdrawUser", paramMap);	
	}
}