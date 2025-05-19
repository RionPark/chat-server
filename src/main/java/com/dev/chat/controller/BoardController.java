package com.dev.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.chat.service.BoardService;
import com.dev.chat.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BoardController {

	@Autowired
	private BoardService boardSerivce;

	@GetMapping("/boards")
	public List<BoardVO> getBoards(BoardVO board){
		log.info("board=>{}", board);
		return boardSerivce.getBoards(board);
	}
	@GetMapping("/boards/{biNum}")
	public BoardVO getBoards(@PathVariable("biNum") int biNum, @RequestParam String type){
		return boardSerivce.getBoard(biNum);
	}
	@GetMapping("/boards/update/{biNum}")
	public BoardVO getBoardsforUpdate(@PathVariable("biNum") int biNum){
		return boardSerivce.getBoard(biNum);
	}
	@PostMapping("/boards")
	public int insertBoard(@RequestBody BoardVO board){
		return boardSerivce.insertBoard(board);
	}
	@PutMapping("/boards")
	public int updateBoards(@RequestBody BoardVO board){
		return boardSerivce.updateBoard(board);
	}
	@DeleteMapping("/boards/{biNum}")
	public int deleteBoards(@PathVariable("biNum") int biNum){
		return boardSerivce.deleteBoard(biNum);
	}
}
