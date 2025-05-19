package com.dev.chat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatRoom {
	private int roomId;
	private String name;
	private int uiNum;
	private String uiName;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
}
