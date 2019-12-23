package com.mimaraslan;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _002_SparkRedis {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");


        //store data in redis list
        jedis.lpush("studentList", "Katerina");
        jedis.lpush("studentList", "Lena");
        jedis.lpush("studentList", "Olga");

        // Get the stored data and print it
        List<String> myList = jedis.lrange("studentList", 0, 15);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + " Stored string in redis:: " + myList.get(i));
        }

        SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[1]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> data = sc.parallelize(myList);

        Map<String, Long> wordCounts = data.countByValue();
        wordCounts.forEach((k, v) -> System.out.println(k + " " + v));
        sc.close();
    }

}
