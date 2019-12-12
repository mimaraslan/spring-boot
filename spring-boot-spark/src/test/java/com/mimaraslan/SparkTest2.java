package com.mimaraslan;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Map;

public class SparkTest2 {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[1]");
		JavaSparkContext sc = new JavaSparkContext(conf);

		//List<String> word = new ArrayList<>();
		//word.add("Katerina");

		JavaRDD<String> words = sc.parallelize(Arrays.asList("Katerina", "Svetlana"));

		Map<String, Long> wordCounts = words.countByValue();
		wordCounts.forEach((k, v) -> System.out.println(k + " " + v));
		sc.close();
	}

}
