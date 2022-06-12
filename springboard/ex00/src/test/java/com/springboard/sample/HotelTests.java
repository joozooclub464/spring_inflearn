package com.springboard.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// @ContextConfiguration : rootcontext가 어디있는지 test클래스에서 알려주는 것
@Log4j
// @Log4j : 롬복에 존재하는 로그를 찍기 위한 라이브러리 
public class HotelTests {
	@Setter(onMethod_ = @Autowired)
	private Hotel hotel; //얘가 정상적으로 주입된다는 뜻은 호텔 안에있는 chef도 정상적으로 주입이 된다는 뜻
	
	@Test
	public void testExist() {
		log.info(hotel);
		log.info(hotel.getChef());
//		System.out.println(hotel);
//		System.out.println(hotel.getChef());
	}
}
