package com.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity(debug=true)
public class securityConfig {

	
	/// settingup/creating the users
	
	private UserDetails userDetails;


				// static way of creating users or user details
	@Bean 
	public InMemoryUserDetailsManager setupUsers()
	{
			
		UserDetails root = User.withUsername("root")
		.password("root")
		.roles("admin","user")
		.build();
		
		UserDetails sathish= User.withUsername("sathish")
		.password("sathish")
		.roles("admin","user")
		.build();
		
		//InMemoryUserDetailsManager class has another constructor,
		//that takes the user objects as arguments, so we are making use of it.
		
		return new InMemoryUserDetailsManager(root,sathish);
	}
	
	
//	@Bean
//	public  InMemoryUserDetailsManager setupUser()
//	{
//		
//		GrantedAuthority obj1=new SimpleGrantedAuthority("admin");
//		GrantedAuthority obj2=new SimpleGrantedAuthority("user");
//		
//		List<GrantedAuthority> ArrayListOne=Arrays.asList(obj1,obj2);
//		
//		
//		UserDetails userDetailsObj=new User("root", "root",ArrayListOne);
//		
//		InMemoryUserDetailsManager userDB = new InMemoryUserDetailsManager();
//		
//		userDB.createUser(userDetailsObj);
//		
//		return userDB;
//
//		
//	}
//	
//	
	@Bean
	public PasswordEncoder getPasswordEncryptor()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
}
