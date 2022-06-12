package com.springboard.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void connectionTest() {
		//try(Statement) : 소괄호 안에 close를 필요로 하는 인스턴스를 작성하게 되면
		//try 문이 끝났을 때 자동으로 close()를 실행해줌. (헷갈리면 finally 써서 직접 close 해주면 됨)
		try(
			Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"web",
				"web"
			)
		) {
			log.info(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
