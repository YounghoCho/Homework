package me.eastglow.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("User")
public class User {
	
	private int appUserId;
	private String nickname;
	private String acessToken;
	private String refreshToken;
	private Date createdAt;
}