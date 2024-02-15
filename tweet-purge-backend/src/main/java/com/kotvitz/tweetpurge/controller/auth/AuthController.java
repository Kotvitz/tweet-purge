package com.kotvitz.tweetpurge.controller.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@GetMapping("/auth/twitter")
	public ResponseEntity<Void> initTwitterAuth() {
		return ResponseEntity.status(HttpStatus.FOUND)
				.header(HttpHeaders.LOCATION, "/oauth2/authorization/twitter")
				.build();
	}
	
	@GetMapping("/auth/twitter/callback")
	public ResponseEntity<Void> handleTwitterLoginCallback() {
		return ResponseEntity.ok().build();
	}
}
