package com.library.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.google.gson.JsonObject;

public class TraceablesLoginFailurehandler implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(200);
		response.setContentType("application/json;charset=UTF-8");
		JsonObject responseBody = new JsonObject();
		if(exception instanceof UsernameNotFoundException)
		responseBody.addProperty("msg", "username not found");
		else if(exception instanceof BadCredentialsException)
			responseBody.addProperty("msg", "password mismatch");
		else
			responseBody.addProperty("msg", "failure");
		try {
			response.getWriter().write(responseBody.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}