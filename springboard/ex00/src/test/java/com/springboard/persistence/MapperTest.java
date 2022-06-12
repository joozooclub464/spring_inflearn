package com.springboard.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboard.mapper.BoardMapper;
import com.springboard.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper2;
	
	@Test
	public void getTimeTest() {
		log.info(mapper.getClass().getName());
		log.info("NOW1 : " + mapper.getTime());
	}
	
	@Test
	public void getTime2Test() {
		log.info("NOW2 : " + mapper.getTime2());
	}
	
	@Test
	public void getBoardnumTest() {
		log.info(mapper2.getBoardnum("apple"));
	}
}
