package com.springboard.mapper;

import java.awt.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboard.domain.BoardDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test 
//	public void getListTest() {
////		log.info(mapper.getList().size());
//		log.info(mapper.getList());
//	}
	
//	@Test
//	public void insertTest() {
//		BoardDTO board = new BoardDTO(); //여기 board객체에는 boardnum이 없음
//										//DB에서 새롭게 긁어오는 애한테는 boardnum이 있음.
//		board.setBoardcontents("매퍼 테스트 내용");
//		board.setBoardtitle("매퍼 테스트 제목");
//		board.setBoardwriter("매퍼 테스트 작성자");
//		log.info("------insertTest-----");
////		mapper.insert(board); //insert로 board를 넘겨야 넘기는 중에 시퀀스를 통해서 boardnum이 부과됨.
//		mapper.insert_with_bno(board);
//		log.info(board);
//	}
	
	//boardnum == 362
	
//	@Test
//	public void deleteTest() {
//		log.info("-----deleteTest-----");
//		mapper.delete((long)362);
//		
//	}


//	@Test
//	public void readTest() {
//		//long --> Long
//		//int --> Integer
//		//정수L, 정수l : long타입 값
//		BoardDTO board = mapper.read(362);
//		log.info(board);
//	}
//	@Test
//	public void deleteTest() {
//		log.info("DELETE : "+mapper.delete(362));
//	}
	
//	@Test
//	public void updateTest() {
//		BoardDTO board = new BoardDTO();
//		log.info("-----updateTest-----");
//		board.setBoardnum((long)362);
//		board.setBoardtitle("매퍼 테스트 제목");
//		board.setBoardwriter("매퍼 테스트 작성자");
//		board.setBoardcontents("매퍼 테스트 내용");
//		mapper.update(board);
//	}
	
	@Test
	public void getTotalTest() {
		log.info(mapper.getTotal());
	}
	
	
}
