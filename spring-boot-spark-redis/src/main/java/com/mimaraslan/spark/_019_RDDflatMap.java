package com.mimaraslan.spark;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class _019_RDDflatMap {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Read Text to RDD")
                .setMaster("local[2]").set("spark.executor.memory", "2g");
        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // provide path to input text file
        String path = "data/rdd/input/myfile1.txt";

        // read text file to RDD
        JavaRDD<String> lines = sc.textFile(path);

        // flatMap each line to words in the line
        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(s.split(" ")).iterator());

        // collect RDD for printing
        for (String word : words.collect()) {
            System.out.println(word);
        }
    }

}