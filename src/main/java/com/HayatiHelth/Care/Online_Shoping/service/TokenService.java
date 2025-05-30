package com.HayatiHelth.Care.Online_Shoping.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenService 
{
	private Map<String, String> tokenStore = new HashMap<>();

	public String generateToken(String userId)
	{
		String token = UUID.randomUUID().toString();
		tokenStore.put(token, userId);
		return token;
	}
	public boolean isValidToken(String token)
	{
		return tokenStore.containsKey(token);
	}
}
