package com.springboard.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Component
//@AllArgsConstructor
// @AllArgsConstructor : 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성한다.
//						 등록되어있는 Chef타입의 chef 하나를 만들어서 주입해줌.
@RequiredArgsConstructor
// @RequiredArgsConstructor : 특정 변수를 위한 생성자를 만들 때 작성. final이 붙거나 @NonNull이 붙은 인스턴스 변수에 대한 생성자를 만들어낸다.
//							ie) 어떤건 주입이 필요하고 어떤건 필요 없을 때(주입이 일어나지 않게 할 때)
public class Hotel {
	@NonNull //@RequiredArgsConstructor가 NonNull에 대한 chef 하나를 받아오는 생성자로 생성이 됨
	private Chef chef;
	
	//생성자를 직접 만드는
//	public Hotel(Chef chef) {
//		this.chef = chef;
//	}
}
