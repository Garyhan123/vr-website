package com.gary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gary.entity.Message;

public interface MessageMapper {
	int insertMessage(Message message);

	List<Message> selectMessageByPage(@Param("start") Integer start, @Param("end") Integer end);

	int selectCountOfMessages();
}
