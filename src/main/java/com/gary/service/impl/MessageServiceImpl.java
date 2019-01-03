package com.gary.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gary.entity.LayuiResult;
import com.gary.entity.Message;
import com.gary.mapper.MessageMapper;
import com.gary.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public void addMessage(Message message) {
		Date date = new Date();
		message.setCreateTime(date);
		message.setUpdateTime(date);
		messageMapper.insertMessage(message);
	}

	@Override
	public LayuiResult<Message> getMessages(Integer page, Integer limit) {
		LayuiResult<Message> result = new LayuiResult<>();
		int start = (page - 1) * limit;
		int end = start + limit;
		List<Message> messages = messageMapper.selectMessageByPage(start, end);
		result.setData(messages);
		result.setCode(0);
		result.setCount(messageMapper.selectCountOfMessages());
		return result;
	}

}
