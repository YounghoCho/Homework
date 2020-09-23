package me.eastglow.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

public class DbConnectionTest {

	private static final String driver = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
	private static final String url = "jdbc:log4jdbc:mysql://localhost/db?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private static final String user = "root";
	private static final String password = "root";
	
	@Test
	public void testConnection() throws Exception{
		
		Class.forName(driver);
		
		try(Connection con = DriverManager.getConnection(url, user, password)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
