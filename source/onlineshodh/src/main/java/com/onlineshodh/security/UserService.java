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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshodh.entity.UserEntity;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	com.onlineshodh.service.UserService userService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
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

}
