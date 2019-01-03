package com.gary.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gary.entity.BaseResponse;
import com.gary.entity.RestStatus;
import com.gary.entity.User;

@RestController
@RequestMapping("user")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * 系统的登录功能  暂时用户名密码写定 : gary_admin和gary_admin
	 * @param username 用户名
	 * @param password 密码
	 * @return BaseResponse 统一返回vo
	 */
	@PostMapping("login")
	public BaseResponse<String> login(HttpSession session, String username, String password) {
		LOGGER.info("请求参数:username:{},password:{}", username, password);
		BaseResponse<String> baseResponse = new BaseResponse<>();
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			LOGGER.info("必填请求参数为空,直接返回前端");
			baseResponse.setRestStatus(RestStatus.PARAM_NULL);
		} else {
			if ("gary_admin".equals(username) && "344b5b11bbea4df996939cd28896d6e6".equals(password)) {
				session.setAttribute("user", new User(username, password));
				LOGGER.info("用户名密码匹配成功；登录成功 username:{},password:{}", username, password);
			} else {
				LOGGER.info("用户名密码匹配失败；登录失败 username:{},password:{}", username, password);
				baseResponse.setRestStatus(RestStatus.PWD_ERROR);
			}
		}
		return baseResponse;
	}
}
