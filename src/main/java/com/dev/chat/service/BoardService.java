package com.dev.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.chat.mapper.BoardMapper;
import com.dev.chat.vo.BoardVO;

@Service
public class BoardService {


	@Autowired
	private BoardMapper boardMapper;

	
	public List<BoardVO> getBoards(BoardVO board){
		return boardMapper.selectBoardList(board);
	}
	public BoardVO getBoard(int biNum) {
		boardMapper.updateBoardViewCnt(biNum);
		return boardMapper.selectBoard(biNum);
	}
	public BoardVO getBoardForUpdate(int biNum) {
		return boardMapper.selectBoard(biNum);
	}
	public int insertBoard(BoardVO board) {
		return boardMapper.insertBoard(board);
	}
	public int updateBoardViewCnt(int biNum) {
		return boardMapper.updateBoardViewCnt(biNum);
	}
	public int updateBoard(BoardVO board) {
		return boardMapper.updateBoard(board);
	}
	public int deleteBoard(int biNum) {
		return boardMapper.deleteBoard(biNum);
	}
	
}
