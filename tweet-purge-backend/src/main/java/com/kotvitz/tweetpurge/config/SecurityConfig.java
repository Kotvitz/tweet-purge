package com.kotvitz.tweetpurge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorizeRequests ->
				authorizeRequests
				.requestMatchers("/", "/login**").permitAll()
				.anyRequest().authenticated()
			)
			.oauth2Login(oauth2Login ->
				oauth2Login
				.loginPage("/login")
				.defaultSuccessUrl("/")
			)
			.logout(logout -> 
				logout
					.logoutSuccessUrl("/login")
					.permitAll()
			);

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	ClientRegistrationRepository clientRegistrationRepository() {
		return new InMemoryClientRegistrationRepository(
			ClientRegistration.withRegistrationId("twitter")
				.clientId(System.getenv("CLIENT_ID"))
				.clientSecret(System.getenv("CLIENT_SECRET"))
				.authorizationUri("https://api.twitter.com/oauth/authenticate")
				.tokenUri("https://api.twitter.com/oauth/access_token")
				.redirectUri("http://localhost:8080/auth/twitter/callback")
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.build()
		);
	}
}
