package com.springboard.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
// @Component : spring에게 해달 클래스가 스프링에서 관리해야 하는 대상임을 표시하는 어노테이션
// 				주입해줘야 할 것을 스프링에게 알려주는 어노테이션.
@Data
// @Data : Lombok의 setter,getter,toString() 등을 자동으로 생성해주는 어노테이션
public class Chef {
	
}
