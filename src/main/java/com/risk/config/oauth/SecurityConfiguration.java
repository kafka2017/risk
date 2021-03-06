package com.risk.config.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * 配置 UserDetailsService ，现在写死，修改 后可以查询数据库
	 */
	@Bean
	@Override
	protected UserDetailsService userDetailsService(){
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
        return manager;
	}

	/**
     * 这一步的配置是必不可少的，否则SpringBoot会自动配置一个AuthenticationManager,覆盖掉内存中的用户
     */
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.requestMatchers().anyRequest()
			.and().authorizeRequests().antMatchers("/oauth/*").permitAll();
			//.and().authorizeRequests().antMatchers("/risk/**").hasRole("USER");
	}
	

}
