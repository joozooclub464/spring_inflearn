package com.springboard.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//그동안의 테스트는 기능들이 잘 구현됐는지만 테스트하면 ok
//컨트롤러 테스트는 뷰도 확인해야 하기 때문에 전반적인 spring mvc구조가 작동할 때 필요한 것들이 다 필요함	
//즉 기능구현 데이터가 있다면 그 데이터가 올바른 곳으로 전달되고 있는지를 테스트함.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/root-context.xml" ,
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
		)
//viewResolver와 같은 것들이 선언되어있는 servlet-context도 필요함 -> 배열로 선언
@Log4j
@WebAppConfiguration
// @WebAppConfiguration : servlet-context를 이용하기 위해서 달아주는 어노테이션(ie 웹사이트처럼 돌아가게 하기 위한 설정들)
public class BoardControllerTest {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext wac;
	
	//가짜 MVC
	//마치 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행해 볼 수 있다.
	private MockMvc mvc;
	
	
	//org.junit.Before
	@Before
	// @Before : 적용된 메소드를 모든 테스트 전에 매번 한번씩 실행한다.
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	//이 이후로는 mvc에 무언가 들어있음 -> 테스트 진행 가능
	
	@Test
	public void listTest() throws Exception {
		//mvc.perform(요청) : 해당 요청대로 mockmvc가 수행
		//MockMvcRequestBuilders.get("/board/list") : board/list로 get방식의 요청!
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andReturn()		//반환된 결과 : 응답(뷰, 모델 등을 포함)
		.getModelAndView();	//응답에서 모델과 뷰를 포함하고 있는 타입의 객체 받기
		
		log.info(mav.getModelMap());
		log.info(mav.getViewName());
		//ie) 이름도 정상이고 map도 정상적로 달려있으면 controller까지는 통과다
	}
	
	
}
