package com.springboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev,next;
	private int total;
	private int pagenum;

	
	public PageDTO(int total, int pagenum) {
		this.total = total;
		this.pagenum = pagenum;
		
		this.endPage = (int)Math.ceil(pagenum/10.0)*10;	
		this.startPage = endPage-9;
		
		this.realEnd = (int)Math.ceil((total*1.0)/10);
		
		if(endPage>realEnd) {
			endPage = realEnd;
		}
		this.prev = this.startPage > 1; 
		this.next = this.endPage < this.realEnd;
		
		
	}
}
