package com.library.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.google.gson.JsonObject;

public class TraceablesLoginSuccesshandler extends SimpleUrlAuthenticationSuccessHandler {

	
	public TraceablesLoginSuccesshandler() {
		super();
		setRedirectStrategy(new NoRedirectStrategy());
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String username = authentication.getName();
		response.setStatus(200);
		response.setContentType("application/json;charset=UTF-8");
		JsonObject responseBody = new JsonObject();
		responseBody.addProperty("username", username);
		responseBody.addProperty("msg", "success");
		
		try {
			response.getWriter().write(responseBody.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class NoRedirectStrategy implements RedirectStrategy {

	public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {

	}

}
