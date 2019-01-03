package com.mimaraslan.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class _008_FilesReadTextToRDD1 {

    public static void main(String[] args) {
// configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Read Multiple Text Files to RDD")
                .setMaster("local[2]").set("spark.executor.memory", "2g");
        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // provide text file paths to be read to RDD, separated by comma
        String files = "data/rdd/input/myfile1.txt,data/rdd/input/myfile2.txt,data/rdd/input/myfile3.txt";

        // read text files to RDD
        JavaRDD<String> lines = sc.textFile(files);

        // collect RDD for printing
        for (String line : lines.collect()) {
            System.out.println(line);
        }
    }
}