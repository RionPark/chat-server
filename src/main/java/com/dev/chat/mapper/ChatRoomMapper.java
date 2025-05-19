package com.dev.chat.mapper;

import java.util.List;

import com.dev.chat.vo.ChatRoom;

public interface ChatRoomMapper {

	List<ChatRoom> selectChatRoomList(ChatRoom chat);
	ChatRoom selectChatRoom(int roomId);
	int deleteChatRoom(int roomId);
	int insertChatRoom(ChatRoom chat);
	int updateChatRoom(ChatRoom chat);
}
