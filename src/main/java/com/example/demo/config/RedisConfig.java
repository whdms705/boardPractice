package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;


public class RedisConfig {
	
	@Value("{}")
	private String hostName;
	
	@Value("{}")
	private int port;
	
	@Bean
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		return jedisPoolConfig;
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean("jedisConnectionFactory")
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
		
		JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
		factory.setHostName(hostName);
		factory.setPort(port);
		factory.setPassword("");
		factory.setUsePool(true);
		
		return factory;
	}
	
	@Bean
	public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory)
	{	
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		
		return redisTemplate;
	}
	
}
