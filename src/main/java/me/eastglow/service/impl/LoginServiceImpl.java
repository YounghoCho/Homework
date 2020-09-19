package me.eastglow.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import me.eastglow.dao.LoginDao;
import me.eastglow.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private LoginDao dao;
	
	@Override
	public String insertToken(String authorize_code) throws Exception {
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
		    sb.append("&code=" + authorize_code);
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
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} 
		//리턴하고 이번엔 프로필 호
		return accessToken;
		
		//삽입
//		dao.insertToken(authorize_code);
	}	
}

