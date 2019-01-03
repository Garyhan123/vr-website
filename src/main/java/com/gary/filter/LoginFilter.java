package com.gary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gary.entity.User;

@Component
@WebFilter(filterName = "loginFilter", urlPatterns = { "/messages.html", "/message/messageList", "/manager.html",
		"/article/updateArticle" })
public class LoginFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(LoginFilter.class);
	private HttpServletRequest request;

	private HttpServletResponse response;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.info("登录过滤器初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		this.request = (HttpServletRequest) request;
		this.response = ((HttpServletResponse) response);
		LOG.info("登录过滤器开始工作了url:" + this.request.getRequestURI());
		User user = (User) this.request.getSession().getAttribute("user");
		if (user == null) {
			LOG.info("未登录状态,执行拦截操作");
			//OperatingSystem os = OperatingSystem.getInstance();
			//String url = os.getVendorName().equals("Linux") ? "/vr/login.html" : "/login.html";
			String url = "/login.html";
			this.response.sendRedirect(url);
		} else {
			LOG.info("已经登录,放行");
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		LOG.info("登录过滤器销毁了");
	}

}
