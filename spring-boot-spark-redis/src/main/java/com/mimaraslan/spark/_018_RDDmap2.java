package com.mimaraslan.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class _018_RDDmap2 {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Read Text to RDD")
                .setMaster("local[2]").set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // initialize an integer RDD
        JavaRDD<Integer> numbers = sc.parallelize(Arrays.asList(10, 50, 200, 470, 500));

        // map each line to number of words in the line
        JavaRDD<Double> log_values = numbers.map(x -> Math.log(x));

        // collect RDD for printing
        for (double value : log_values.collect()) {
            System.out.println(value);
        }
    }
}