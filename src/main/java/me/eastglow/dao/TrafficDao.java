package me.eastglow.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TrafficDao")
public class TrafficDao {
	private static final String NAMESPACE_API = "apiCall.";
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	/*
	 * des : 필에서 수집한 HTTP request & body 기록.
	 */
	public void insertTraffic(String request, String response) {
		HashMap<String, Object> paramMap = new HashMap<>();		
		paramMap.put("request", request);
		paramMap.put("response", response);
		
		sqlsession.insert(NAMESPACE_API + "insertTraffic", paramMap);	
	}
}
