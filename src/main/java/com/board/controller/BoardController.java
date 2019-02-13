package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.domain.PageMaker;
import com.board.domain.SearchCriteria;
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
	 public void getRead(@RequestParam("bno")int bno,
			 			@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
		 logger.info("get read");
		 BoardVO vo = service.read(bno);
		 model.addAttribute("read", vo);
		 model.addAttribute("scri", scri);
	 }
	 
	 //수정 get
	 @RequestMapping(value="modify", method=RequestMethod.GET)
	 public void update(@RequestParam("bno")int bno, Model model) throws Exception {
		 logger.info("get update");
		 BoardVO vo = service.read(bno);
		 
		 model.addAttribute("modify", vo);
	 }
	 
	//수정 post
		 @RequestMapping(value="modify", method=RequestMethod.POST)
		 public String update(BoardVO vo,
				 			@ModelAttribute("scri")SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			 logger.info("post update");
			 
			 service.update(vo);
			 
			 rttr.addAttribute("page", scri.getPage());
			 rttr.addAttribute("perPageNum", scri.getPerPageNum());
			 rttr.addAttribute("searchType", scri.getSearchType());
			 rttr.addAttribute("keyword", scri.getKeyword());
			 
			 return "redirect:/board/listSearch";
		 }
	 
	 //삭제 get
	 @RequestMapping(value="delete", method = RequestMethod.GET)
	 public void delete(@RequestParam("bno")int bno, Model model) throws Exception{
		 logger.info("get delete");
		 
		 model.addAttribute("delete", bno);
	 }
	 
	//삭제 post
	 @RequestMapping(value="delete", method = RequestMethod.POST)
	 public String delete(@RequestParam("bno")int bno,
			 			@ModelAttribute("scri")SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		 logger.info("post delete");
		 
		 service.delete(bno);
		 
		 rttr.addAttribute("page", scri.getPage());
		 rttr.addAttribute("perPageNum", scri.getPerPageNum());
		 rttr.addAttribute("searchType", scri.getSearchType());
		 rttr.addAttribute("keyword", scri.getKeyword());
		
		 return "redirect:/board/listSearch";
	 }
	 
	 //글 목록 + 페이징
	 @RequestMapping(value="/listPage", method = RequestMethod.GET)
	 public void listPage(Criteria cri, Model model) throws Exception {
		 logger.info(cri.toString());
		 
		 List<BoardVO> list = service.listPage(cri);
		 model.addAttribute("list", list);
		 
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(cri);
		 pageMaker.setTotalCount(service.listCount());
		 model.addAttribute("pageMaker", pageMaker);
		 
	 }
	 
	 //글 목록 + 페이징 + 검색
	 @RequestMapping(value = "/listSearch", method = RequestMethod.GET)
	 public void listSearch(@ModelAttribute("scri")SearchCriteria scri, 
			 				Model model, String searchType) throws Exception{
		 logger.info("get listSearch");
		 
		 List<BoardVO> list = service.listSearch(scri);
		 model.addAttribute("list", list);
		 
		 PageMaker pageMaker = new PageMaker();
		 pageMaker.setCri(scri);
		 pageMaker.setTotalCount(service.listCount());
		 model.addAttribute("pageMaker", pageMaker);
		 
	 }
}
