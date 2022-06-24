package com.springboard.mapper;

import java.util.List;

import com.springboard.domain.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> getList();
	
	void insert(BoardDTO board);
	void insert_with_bno (BoardDTO board);
	
	
	BoardDTO read(Long boardnum);
	//게시글이 삭제되었다면 1 이상의 값이 리턴되고
	//없는 게시글이라면(삭제가 안됐다면) 0이 리턴된다.
	int delete(Long boardnum);
	int update(BoardDTO board);
	
	
	
	
	
}
