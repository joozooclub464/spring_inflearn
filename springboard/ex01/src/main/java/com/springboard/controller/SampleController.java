package com.springboard.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboard.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
// @Controller : 컨트롤러로서 일할 수 있도록 등록을 해주는 것
@RequestMapping("/sample/*")
// @RequestMapping : 뒤에 /sample/* 이 붙어있으면 여기로 와라
@Log4j
public class SampleController {
	//SampleController는 Jsp에서 FrontController의 역할임
	
//	@RequestMapping("") //  /sample/  이면 basic 호출됨
//	public String basic() {
//		log.info("====================basic==================");
//		return "a"; // ViewResolver로 리턴됨
//	}
	@RequestMapping("basic1")
	public void basic1(int age) {
		log.info("====================basic1==================");	
		log.info("나이 : " + age);
	}
	
	//get, post방식
	
	@GetMapping("basic")
	public void basicGet() {
		log.info("=============get 방식으로 요쳥=============");
	}
	//댓글 수정 삭제시 응용했음
	@PostMapping("basic")
	public void basicPost(int age) {
		log.info("=============post 방식으로 요쳥=============");
		log.info("나이 : "+age);
	}
	
	//여러 전송 방법을 다 맵핑을 시킬거면 method라는 변수로 설정해주면 됨
	@RequestMapping(value="basic2", method= {RequestMethod.GET, RequestMethod.POST})
	public void basic2() {
		log.info("=============get,post 방식으로 요쳥=============");
	}
	
	//Controller 파라미터 수집 방법
	@GetMapping("ex01")
	public String ex01(SampleDTO dto , Model model) {
		model.addAttribute("sample", dto);
		log.info(dto);
		return "/sample/ex01";
	}
	//파라미터 명과 담을 변수명이 다른 경우 수집 방법
	@GetMapping("ex02")
	public String ex02(@RequestParam("data1")String name, @RequestParam("data2")int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "/sample/ex02";
	}
	
	//파라미터가 같은 이름으로 여러개 날아오는 경우(ex:checkbox) 수집방법
	@GetMapping("ex03")
	public String ex03(@RequestParam("data")String[] datas, Model model) {
		model.addAttribute("datas",datas);
		return "/sample/ex03";
	}
	@GetMapping("ex04")
	public String ex04(@RequestParam("data")ArrayList<Integer> datas, Model model) {
		model.addAttribute("datas",datas);
		return "/sample/ex04";
	}


}
