package com.dev.chat.mapper;

import java.util.List;

import com.dev.chat.vo.ChatRoom;
import com.dev.chat.vo.CrUiMap;

public interface CrUiMapMapper {

	int insertCrUiMap(ChatRoom crUi);
	int deleteCrUiMap(CrUiMap crUi);
	List<CrUiMap> selectCrUiMapList(int roomId);
}
