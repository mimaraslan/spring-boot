package com.mimaraslan.redis;

import redis.clients.jedis.Jedis;

public class _001_RedisJava {
	public static void main(String[] args) {

		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost");

		try {
			// check whether server is running or not
			System.out.println("Server is running: " + jedis.ping());
			System.out.println("Connection to server sucessfully");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}