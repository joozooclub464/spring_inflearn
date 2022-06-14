package com.springboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

//예외가 발생했을 때 무조건 이곳으로 오게 만들것.
@ControllerAdvice
// @ControllerAdvice : 해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@Log4j
public class CommonExceptionAdvice {
	@ExceptionHandler(Exception.class)
	//발생한 예외가 Exception 타입이면 다 이 안으로 들어와서 호출함. == 모든 에러가 해당함.
	//@ExceptionHandler() : 해당하는 예외의 경우에 이 안으로 들어와서 실행함
	public String exception(Exception e, Model model) {
		log.error("Exception : " + e.getMessage());
		model.addAttribute("e", e);
		return "error_page";
		
	}
	
	//500 예외는 문법 오류 발생시 @ExceptionHandler를 이용해서 처리가 가능하지만, 
	//404 메시지는 오류가 아닌 URL을 잘못 호출했을 때 처리해야 한다. 따라서 서블릿이 web.xml에 간 후
	//어디로 가야할 지 모를 때 NoHandlerFoundException을 발생시켜 줌으로써 예외가 발생되고
	//그 예외를 nhfe 객체가 잡아준다. 따라서 404 메세지 대신 원하는 페이지로 응답할 수 있게 된다.
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String exception404(NoHandlerFoundException nhfe) {
		return "404_page";
	}

}
