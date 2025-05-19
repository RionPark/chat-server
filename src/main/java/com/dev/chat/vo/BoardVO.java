package com.dev.chat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {

	private int biNum;
	private String biTitle;
	private String biContent;
	private int  uiNum;
	private String uiName;
	private int biViewCnt;
	private String credat;
	private String cretim;
	private String lmodat;
	private String lmotim;
}
