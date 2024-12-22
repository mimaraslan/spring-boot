package com.mimaraslan;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class _004_RedisKeyJava {
	public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");

		Set<String> keys = jedis.keys("*");
		keys.forEach(System.out::println);

		System.out.println("-------------------------------");

		System.out.println("List of stored keys:: " + keys);

		System.out.println("-------------------------------");

		for (String s : keys) {
            System.out.println("List of stored keys:: " + s);
        }

	}
}