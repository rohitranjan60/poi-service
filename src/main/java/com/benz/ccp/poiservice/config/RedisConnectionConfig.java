package com.benz.ccp.poiservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConnectionConfig {

	@Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    
	@Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
}
