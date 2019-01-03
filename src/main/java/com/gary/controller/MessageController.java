package com.gary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.gary.entity.LayuiResult;
import com.gary.entity.Message;
import com.gary.service.MessageService;

@RequestMapping("message")
@RestController
public class MessageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;

	@PostMapping("addMessage")
	public void addMessage( Message message) {
		LOGGER.info("请求参数:{}", JSON.toJSONString(message));
		messageService.addMessage(message);
	}

	@GetMapping("messageList")
	public LayuiResult<Message> getMessages(Integer page, Integer limit) {
		return   messageService.getMessages(page,limit);
		
	}
}
