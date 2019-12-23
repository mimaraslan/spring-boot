package com.mimaraslan;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.Map;

public class _001_SparkRedis {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        //set the data in redis string
        jedis.set("studentName", "Katerina");

        // Get the stored data and print it
        System.out.println("Stored string in redis:: " + jedis.get("studentName"));


        SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[1]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> data = sc.parallelize(Arrays.asList(jedis.get("studentName")));

        Map<String, Long> wordCounts = data.countByValue();
        wordCounts.forEach((k, v) -> System.out.println(k + " " + v));
        sc.close();
    }

}
