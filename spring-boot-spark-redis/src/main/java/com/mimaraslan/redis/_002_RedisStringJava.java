package com.mimaraslan.redis;

import redis.clients.jedis.Jedis;

public class _002_RedisStringJava {
	public static void main(String[] args) {

		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost");

		try {
			// set the data in redis string
			jedis.set("studentName", "Katerina");

			// Get the stored data and print it
			System.out.println("Stored string in redis:: " + jedis.get("studentName"));
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

	}
}