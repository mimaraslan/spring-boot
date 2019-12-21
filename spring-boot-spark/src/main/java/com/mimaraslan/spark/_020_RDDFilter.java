package com.mimaraslan.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

public class _020_RDDFilter {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Spark RDD Filter")
                .setMaster("local[2]").set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // read list to RDD
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        JavaRDD<Integer> rdd = sc.parallelize(data, 1);

        // filter : where the number (rdd element) is exactly divisible by 3
        Function<Integer, Boolean> myFilter = k -> (k % 3 == 0);

        // apply filter on rdd with filter passed as argument
        JavaRDD<Integer> rddf = rdd.filter(myFilter);

        // print the filtered rdd
        rddf.foreach(element -> {
            System.out.println(element);
        });

        sc.close();
    }
}