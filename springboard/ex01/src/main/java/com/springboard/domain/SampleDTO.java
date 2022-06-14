package com.springboard.domain;

import lombok.Data;

@Data
// @Data : getter,setter,equals(),toString,hashCode() .. 재정의(자동생성)
public class SampleDTO {
	private String name;
	private int age;
	
}
