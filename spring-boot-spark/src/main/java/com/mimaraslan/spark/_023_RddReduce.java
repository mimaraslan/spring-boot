package com.mimaraslan.spark;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class _023_RddReduce {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Read Text to RDD")
                .setMaster("local[2]").set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // read text file to RDD
        JavaRDD<Integer> myNumbers = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5));

        // aggregate numbers using addition operator
        int sum = myNumbers.reduce((a, b) -> a + b);

        System.out.println("Sum of numbers is : " + sum);
    }
}