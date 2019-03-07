package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	//CRUD 기능의 메소드 구현
	//글 등록
	void insertBoard(BoardVO vo);

	//글 수정
	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);

}