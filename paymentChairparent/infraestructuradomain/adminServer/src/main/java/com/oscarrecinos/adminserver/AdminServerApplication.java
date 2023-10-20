package com.oscarrecinos.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableAdminServer
public class AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}

	@Configuration
	public static class WebSecurityConfig {

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.csrf(c -> c.disable()).authorizeRequests().anyRequest().permitAll();

			//http.csrf().disable().authorizeRequests().anyRequest().permitAll();


			// http....;

			return http.build();
		}
	}

}
