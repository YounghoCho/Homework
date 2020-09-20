package me.eastglow.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.eastglow.dao.LoginDao;
import me.eastglow.service.LoginService;
import me.eastglow.vo.User;

/*
 * des : 카카오 로그인 
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private LoginDao dao;
	
	private String accessTokenForDao;
	private String refreshTokenForDao;
	private int appUserIdForDao;
	private String nickNameForDao;	
	
	/*
	 * des : 최초 접속시 kakao로부터 받아온 code로 토큰을 받아온.
	 */
	@Override
	public String getToken(String authorizCode) throws Exception {
		String accessToken = "";
		String refreshToken = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		
		try {
		    URL url = new URL(reqURL);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    
		    //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
		    conn.setRequestMethod("POST");
		    conn.setDoOutput(true);
		    
		    //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		    StringBuilder sb = new StringBuilder();
		    sb.append("grant_type=authorization_code");
		    sb.append("&client_id=3203fb9b237c44cf427b37c2e3cb4319");
		    sb.append("&redirect_uri=http://localhost:8080/oauth");
		    sb.append("&code=" + authorizCode);
		    bw.write(sb.toString());
		    bw.flush();
		    
		    //    결과 코드가 200이라면 성공
		    int responseCode = conn.getResponseCode();
		    System.out.println("responseCode : " + responseCode);
		 
		            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
		    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String line = "";
		    String result = "";
		    while ((line = br.readLine()) != null) {
		        result += line;
		    }
		    System.out.println("response body : " + result);
		    
		    //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
		    JsonParser parser = new JsonParser();
		    JsonElement element = parser.parse(result);
		    
		    accessToken = element.getAsJsonObject().get("access_token").getAsString();
		    refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
		    System.out.println("access_token : " + accessToken);
		    System.out.println("refresh_token : " + refreshToken);
		    
		    br.close();
		    bw.close();
		    
		    //토큰 기록.
			accessTokenForDao = accessToken;
			refreshTokenForDao = refreshToken;
		    
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		
		return accessToken;
		
	}	
	
	/*
	 * des :토큰으로 kakao로부터 사용자의 정보를 받아온다.
	 */
	@Override
	public int getUser(String accessToken) {
		 String reqURL = "https://kapi.kakao.com/v2/user/me";
		    try {
		        URL url = new URL(reqURL);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("POST");
		        
		        //    요청에 필요한 Header에 포함될 내용
		        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
		        int responseCode = conn.getResponseCode();
		        System.out.println("responseCode : " + responseCode);
		        
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	        
		        String line = "";
		        String result = "";	        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        System.out.println("response body : " + result);
		        
		        JsonParser parser = new JsonParser();
		        JsonElement element = parser.parse(result);
		        
		        //Get ID, Nickname
		        int id = element.getAsJsonObject().get("id").getAsInt();
		        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
		        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
		        
			    appUserIdForDao = id;
			    nickNameForDao = nickname;
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return appUserIdForDao;
	}
	
	/*
	 * des :로그인을 시도한 사용자가 회원가입 되어있는지 판단하기 위해 DB에서 조회한다.
	 */
	@Override
	public int getAppUserDB(int appUserId) {
		int appUserIdDB = dao.getAppUserId(appUserId);
		return appUserIdDB;
	}
	
	/*
	 * des : 최초 접속자인 사용자는 회원가입을 자동으로 진행한다.
	 */
	public void addUser (String accessToken) {
	    
	    String reqURL = "https://kapi.kakao.com/v2/user/me";
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        
	        //    요청에 필요한 Header에 포함될 내용
	        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	        
	        String line = "";
	        String result = "";	        
	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        System.out.println("response body : " + result);
	        
	        JsonParser parser = new JsonParser();
	        JsonElement element = parser.parse(result);
	        
	        //Get ID, Nickname
	        int id = element.getAsJsonObject().get("id").getAsInt();
	        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
	        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
	        
		    appUserIdForDao = id;
		    nickNameForDao = nickname;
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    dao.addUser(accessTokenForDao, refreshTokenForDao, appUserIdForDao, nickNameForDao);
	}
	
	/*
	 * des : 프로필 조회.
	 */
	@Override
	public List<User> getProfile(String id) {
		return dao.getProfile(id);
	}





}

