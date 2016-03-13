package com.vector.tfriend.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * @author vector.huang
 * @date 2016年2月29日 下午1:25:00
 */
@Component
public class CustomExceptionView implements View {

	public static final String KEY_EXCEPTION_RESULT = "result";

	@Override
	public String getContentType() {
		return "application/json";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.getWriter().print(model.get(KEY_EXCEPTION_RESULT));
	}

}
