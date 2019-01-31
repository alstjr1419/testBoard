package com.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger Logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	// 글 작성 get
	@RequestMapping(value = "/wite", method = RequestMethod.GET)
	public void getWrite() throws Exception {
		Logger.info("get write");
		
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception{
		Logger.info("post write");
		
		service.write(vo);
		//t
		return "redirect :/";
	}
	
}
