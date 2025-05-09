package com.dev.chat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dev.chat.mapper")
public class ChatServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatServerApplication.class, args);
	}

}
