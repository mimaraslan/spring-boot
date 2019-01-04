package com.mimaraslan.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

public class _005_PrintRDD {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Print Elements of RDD")
                .setMaster("local[2]").set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // read text files to RDD
        JavaRDD<String> lines = sc.textFile("data/rdd/input/myfile1.txt");

        lines.foreach(new VoidFunction<String>() {
            public void call(String line) {
                System.out.println("* " + line);
            }
        });
    }
}