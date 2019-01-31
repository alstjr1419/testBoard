package com.board.presistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.board.domain.BoardVO;

public class BoardDAOImpl implements BoardDAO{
	
	//마이바티스
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.board.mappers.testMapper";
	
	//작성
	@Override
	public void write(BoardVO vo) throws Exception {
		sql.insert(namespace + ".write", vo);
	}
	
	//조회
	@Override
	public BoardVO read(int bno) throws Exception {
		sql.selectOne(namespace + ".read", bno);
		return null;
	}
	
	//수정
	@Override
	public void update(BoardVO vo) throws Exception {
		sql.update(namespace + ".update", vo);
		
	}
	
	//삭제
	@Override
	public void delete(int bno) throws Exception {
		sql.delete(namespace +  ".delete", bno);
	}

}
