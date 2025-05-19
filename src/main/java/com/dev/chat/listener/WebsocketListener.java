package com.dev.chat.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebsocketListener {

	@EventListener
	public void disconnectListener(SessionDisconnectEvent sde) {
		log.info("SessionDisconnectEvent=>{}",sde);
		log.info("SessionDisconnectEvent=>{}",sde.getUser());
	}
}
