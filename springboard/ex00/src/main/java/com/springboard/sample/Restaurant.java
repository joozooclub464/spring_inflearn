package com.springboard.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	@Setter(onMethod_ = @Autowired)
	// @Setter(onMethod_ = @Autowired) : set chef를 이용해서 주입할건데, 자동으로 연결되어 있는걸로 주입해줘 
	private Chef chef;
}
