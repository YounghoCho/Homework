package me.eastglow.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("testVO")
public class TestVO {
	
	private int id ;
	private String nickname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}