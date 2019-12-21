package com.mimaraslan.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class _002_SparkTest2_count {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[1]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        //	JavaSparkContext sc = new JavaSparkContext("local", "Count files");

        List<String> data = Arrays.asList("Katerina", "Svetlana", "Lena", "Anna", "Olga");

        JavaRDD<String> rdd = sc.parallelize(data);
        System.out.println("Count : " + rdd.count());
        System.out.println("First : " + rdd.first());
        sc.close();
    }
}