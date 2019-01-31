package com.board.service;

import javax.inject.Inject;

import com.board.domain.BoardVO;
import com.board.presistence.BoardDAO;

public class BoardSerciveImpl implements BoardService{
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}

}
