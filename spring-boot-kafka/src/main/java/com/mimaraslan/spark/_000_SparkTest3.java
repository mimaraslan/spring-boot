package com.mimaraslan.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _000_SparkTest3 {

	public static void main(String[] args) {
		//	SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[1]");
		//	JavaSparkContext sc = new JavaSparkContext(conf);
		JavaSparkContext sc = new JavaSparkContext("local", "Count files");

		String directory = System.getProperty("user.home");
		String fileName = "/Documents/workspace/spring-boot/spring-boot-spark/src/data/mydata.txt";
		String absolutePath = directory + File.separator + fileName;


		JavaRDD<String> textFileRDD = sc.textFile("/home/mimaraslan/Documents/workspace/spring-boot/spring-boot-spark/src/data/mytestdata.txt");

		System.out.println("lolo Count:" + textFileRDD.count());
		sc.close();
	}
}