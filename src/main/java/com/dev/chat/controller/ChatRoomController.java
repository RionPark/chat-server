package com.dev.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.chat.service.ChatRoomService;
import com.dev.chat.vo.ChatRoom;

@RestController
public class ChatRoomController {

	@Autowired
	private ChatRoomService crService;

	@GetMapping("/chatrooms")
	public List<ChatRoom> selectChatRoomList(ChatRoom chat){
		return crService.selectChatRoomList(chat);
	}
	@GetMapping("/chatrooms/{roomId}")
	public ChatRoom selectChatRoom(@PathVariable("roomId")int roomId){
		return crService.selectChatRoom(roomId);
	}
	@DeleteMapping("/chatrooms/{roomId}")
	public int deleteChatRoom(@PathVariable("roomId")int roomId){
		return crService.deleteChatRoom(roomId);
	}
	@PostMapping("/chatrooms")
	public int insertChatRoom(@RequestBody ChatRoom chat){
		return crService.insertChatRoom(chat);
	}
	@PutMapping("/chatrooms")
	public int updateChatRoom(@RequestBody ChatRoom chat){
		return crService.updateChatRoom(chat);
	}
}
