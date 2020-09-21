package me.eastglow.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.eastglow.vo.User;

/*
 * des : 전체 사용자 조회.
 */
@Repository("SearchDao")
public class SearchDao {
	private static final String NAMESPACE_API = "apiCall.";

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	/*
	 * des : 프로필 조회.
	 */
	public List<User> searchAllUsers() {
		return sqlsession.selectList(NAMESPACE_API + "searchAllUsers");
	}
	public List<User> searchUserbyNickname(String nickname) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("nickname", nickname);
		return sqlsession.selectList(NAMESPACE_API + "searchUserbyNickname", paramMap);
	}
}