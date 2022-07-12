package com.springboard.service;

import java.util.List;

import com.springboard.domain.BoardDTO;

public interface BoardService {
	//list를 검색해서 가져오는기능
	public List<BoardDTO> getList();

	public int getTotal();
}
