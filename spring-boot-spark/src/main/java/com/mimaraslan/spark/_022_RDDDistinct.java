package com.mimaraslan.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class _022_RDDDistinct {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Spark RDD Distinct")
                .setMaster("local[2]")
                .set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // read list to RDD
        List<String> data = Arrays.asList("A", "A", "A", "B", "B", "C", "C", "C", "C", "C");
        JavaRDD<String> words = sc.parallelize(data, 1);

        // get distinct elements of RDD
        JavaRDD<String> rddDistinct = words.distinct();

        // print
        rddDistinct.foreach(item -> {
            System.out.println(item);
        });

        sc.close();
    }
}