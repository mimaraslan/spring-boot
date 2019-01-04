package com.mimaraslan.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

public class _006_ReadTextToRDD {

    public static void main(String[] args) {
        // configure spark
        // SparkConf sparkConf = new SparkConf().setAppName("Read Text to RDD")
        //        .setMaster("local[2]").set("spark.executor.memory","2g");

        SparkConf sparkConf = new SparkConf().setAppName("Print Elements of RDD")
                .setMaster("local[2]").set("spark.executor.memory", "2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // provide path to input text file
        String path = "data/rdd/input/myfile1.txt";

        // read text file to RDD
        JavaRDD<String> lines = sc.textFile(path);

        // collect RDD for printing
        for (String line : lines.collect()) {
            System.out.println(" " + line);
        }

        lines.foreach(new VoidFunction<String>() {
            public void call(String line) {
                System.out.println("* " + line);
            }
        });
    }
}