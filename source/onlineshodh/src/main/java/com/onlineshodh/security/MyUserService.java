package com.onlineshodh.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.entity.UserEntity;

@Service
public class MyUserService implements UserDetailsService {

	@Autowired
	private com.onlineshodh.service.UserService userService;
	
	public MyUserService() {
		super();
	}

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		UserEntity user = userService.getUserByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
		
		UserDetails userDetails = buildUserEntityForAuthentication(user,authorities);
		return userDetails;
	}
	
	private User buildUserEntityForAuthentication(UserEntity userEntity,List<GrantedAuthority> authorities)
	{
		User user = new User(userEntity.getUserName(), userEntity.getPassword(), userEntity.isEnabled(), userEntity.isAccountNonExpired(), userEntity.isCredentialsNonExpired(), userEntity.isAccountNonLocked(), authorities);
		return user;
	}
	
	private List<GrantedAuthority> buildUserAuthority(String role)
	{
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(role));
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
		return result;
	}

	public com.onlineshodh.service.UserService getUserService() {
		return userService;
	}

	public void setUserService(com.onlineshodh.service.UserService userService) {
		this.userService = userService;
	}
}
