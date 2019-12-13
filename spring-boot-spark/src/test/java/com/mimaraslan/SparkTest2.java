package com.mimaraslan;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SparkTest2 {

	public static void main(String[] args) {
		//SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[1]");
		//JavaSparkContext sc = new JavaSparkContext(conf);

		JavaSparkContext sc = new JavaSparkContext("local", "Count files");
		List<String> data = Arrays.asList("Hello","world","!!","!!","!!");
		JavaRDD<String> rdd = sc.parallelize(data);
		System.out.println("Count : " + rdd.count());
		System.out.println("First : " + rdd.first());

		sc.close();
	}

}