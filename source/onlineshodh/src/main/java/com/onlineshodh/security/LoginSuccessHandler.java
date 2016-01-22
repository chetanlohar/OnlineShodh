package com.onlineshodh.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.onlineshodh.service.UserDetailsService;
import com.onlineshodh.service.UserService;

@Component("loginSuccessHandler")
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetails;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		String username = authentication.getName();
		
		String imageFilePath = userDetails.getUserDetailsByUserId(userService.getUserByUserName(username).getUserId()).getUserdetailsFilePath();
		
		request.getSession().setAttribute("userPhoto", imageFilePath);
		
		System.out.println(imageFilePath);
		
		if(roles.contains("ROLE_ADMIN"))
		{
			redirectStrategy.sendRedirect(request, response, "/admin/home");
			return;
		}
		redirectStrategy.sendRedirect(request, response, "/");
	}
}
