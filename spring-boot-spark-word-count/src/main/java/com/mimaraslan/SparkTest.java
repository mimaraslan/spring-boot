package com.mimaraslan;

import java.util.Arrays;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkTest {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("MySparkWordCountTest").setMaster("local[2]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> words = sc.parallelize(Arrays.asList("B", "B", "C", "C", "C", "A", "B", "B", "D", "D"));
		Map<String, Long> wordCounts = words.countByValue();
		wordCounts.forEach((k, v) -> System.out.println(k + " " + v));
		sc.close();
	}

}