package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	 // 글 작성 get
	 @RequestMapping(value = "/write", method = RequestMethod.GET)
	 public void getWrite() throws Exception {
	  logger.info("get write");
	 }

	 // 글 작성 post
	 @RequestMapping(value = "/write", method = RequestMethod.POST)
	 public String postWrite(BoardVO vo) throws Exception {
	  logger.info("post write");
	  service.write(vo);
	  
	  return "redirect:/board/list";
	 }
	 
	 //목록
	 @RequestMapping(value="/list", method = RequestMethod.GET)
	 public void list(Model model) throws Exception{
		 logger.info("get list");
		 List<BoardVO> list =  service.list();
		 model.addAttribute("list", list);
	 }
	 
	 //조회
	 @RequestMapping(value="/read", method = RequestMethod.GET)
	 public void getRead(@RequestParam("bno")int bno, Model model) throws Exception{
		 logger.info("get read");
		 BoardVO vo = service.read(bno);
		 model.addAttribute("read", vo);
	 }
	 
	 //수정
	 @RequestMapping(value="modify", method=RequestMethod.GET)
	 public void update(@RequestParam("bno")int bno, Model model) throws Exception {
		 logger.info("get update");
		 BoardVO vo = service.read(bno);
		 
		 model.addAttribute("modify", vo);
	 }
	 
	//수정 post
		 @RequestMapping(value="modify", method=RequestMethod.POST)
		 public String update(BoardVO vo) throws Exception {
			 logger.info("post update");
			 
			 service.update(vo);
			 
			 return "redirect:/board/list";
		 }
	 
	 //삭제
	 @RequestMapping(value="delete", method = RequestMethod.GET)
	 public void delete(@RequestParam("bno")int bno, Model model) throws Exception{
		 logger.info("get delete");
		 
		 model.addAttribute("delete", bno);
	 }
	 
	//삭제 post
	 @RequestMapping(value="delete", method = RequestMethod.POST)
	 public String delete(@RequestParam("bno")int bno) throws Exception{
		 logger.info("post delete");
		 
		 service.delete(bno);
		
		 return "redirect:/board/list";
	 }
}
