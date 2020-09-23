package me.eastglow.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("Traffic")
public class Traffic {
	private String request;
	private String response;
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

}
