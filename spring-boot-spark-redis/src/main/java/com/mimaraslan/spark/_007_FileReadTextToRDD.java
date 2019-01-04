package com.mimaraslan.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class _007_FileReadTextToRDD {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Spark RDD foreach Example")
                .setMaster("local[2]").set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // provide path to input text file
        String path = "data/rdd/input/myfile1.txt";

        // read text file to RDD
        JavaRDD<String> lines = sc.textFile(path);

        // collect RDD for printing
        for (String line : lines.collect()) {
            System.out.println(line);
        }

    }
}