package me.blog.youreme.payback.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Login {
	
	@NonNull private String cookie;
	private boolean isLogged;
	private long userId;
	private User user;

}
