package com.springboard.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//spring-test 모듈을 이용해서 간단하게 스프링을 가동시키고 스프링 동작을 확성화한다.
@RunWith(SpringJUnit4ClassRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class) : 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RestaurantTests {
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	@Test
	// @Test : JUnit에서 테스트 대상임을 표시(반드시 public으로 만들어야 함)
	public void testExist() {
		assertNotNull(restaurant); //restaurant 객체가 null이 아니면 테스트 성공
		log.info(restaurant);
		log.info("=================");
		log.info(restaurant.getChef());
		
	}
//	1. 테스트 코드가 실행되기 위해서 스프링 프레임워크가 동작
//	2. 동작하는 과정에서 필요한 객체들이 스프링에 등록
//	3. 의존성 주입이 필요한 객체는 자동으로 주입이 이루어짐
}
