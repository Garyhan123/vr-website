package com.gary.service;

import com.gary.entity.LayuiResult;
import com.gary.entity.Message;

public interface MessageService {
	void addMessage(Message message);
	
	LayuiResult<Message> getMessages(Integer page,Integer limit);
}
