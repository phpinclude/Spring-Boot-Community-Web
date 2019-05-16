package com.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.annotation.SocialUser;
import com.web.domain.User;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping( value = {"/{facebook|google|kakao}/complete"})
	public String loginComplete(@SocialUser User user) {
		
		System.out.println("loginComplate call");
		
		return "redirect:/board/list";
	}
}
