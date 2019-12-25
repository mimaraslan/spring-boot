package com.mimaraslan;
import java.util.List;

import redis.clients.jedis.Jedis; 

public class _003_RedisListJava {
   public static void main(String[] args) { 
   
      //Connecting to Redis server on localhost 
      Jedis jedis = new Jedis("localhost"); 
      System.out.println("Connection to server sucessfully"); 
      
      //store data in redis list 
      jedis.lpush("studentList", "A");
      jedis.lpush("studentList", "B");
      jedis.lpush("studentList", "C");


      // Get the stored data and print it 
      List<String> myList = jedis.lrange("studentList", 0 ,15);
      
      for(int i = 0; i<myList.size(); i++) {
         System.out.println(i+" Stored string in redis:: "+myList.get(i));
      } 
   } 
} 