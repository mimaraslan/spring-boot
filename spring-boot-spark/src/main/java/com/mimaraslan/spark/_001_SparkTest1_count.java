package com.mimaraslan.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.Map;

public class _001_SparkTest1_count {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[1]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		//	JavaSparkContext sc = new JavaSparkContext("local", "Count files");

		JavaRDD<String> data = sc.parallelize(Arrays.asList("Katerina", "Katerina", "Svetlana"));

		Map<String, Long> wordCounts = data.countByValue();
		wordCounts.forEach((k, v) -> System.out.println(k + " " + v));
		sc.close();
	}
}