package com.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.domain.User;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping( value = "/facebook/complete")
	public String loginComplete(HttpSession session) {
		
		System.out.println("loginComplate call");
		
		OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		
		Map<String, String> map = (HashMap<String, String>) authentication.getUserAuthentication().getDetails();
		
		System.out.println(map);
		
		session.setAttribute("user", User.builder()
				.name(map.get("name"))
				.email(map.get("email"))
				.principal(map.get("id"))
				.createdDate(LocalDateTime.now())
				.build()
				);
		return "redirect:/board/list";
	}
}
