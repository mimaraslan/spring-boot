package com.mimaraslan.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class _011_RDDforEach {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Spark RDD foreach Example")
                .setMaster("local[2]").set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // read list to RDD
        List<String> data = Arrays.asList("Katerina", "Katerina", "Olga", "Anya", "Rita", "Katerina", "Svetlana", "Ira", "Lena");
        JavaRDD<String> items = sc.parallelize(data, 1);

        // apply a function for each element of RDD
        items.foreach(item -> {
            System.out.println("* " + item);
        });
    }
}
