package com.springbook.biz.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport {
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 InsertBoard()기능 처리");
		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(),vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 updateBoard()기능 처리");
		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(),vo.getContent(), vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 deleteBoard()기능 처리");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
		
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoard()기능 처리");
		Object[] args = {vo.getSeq()};
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===>Spring JDBC로 getBoardList()기능 처리");
		
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
}
