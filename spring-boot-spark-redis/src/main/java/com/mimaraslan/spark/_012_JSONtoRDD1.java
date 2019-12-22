package com.mimaraslan.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class _012_JSONtoRDD1 {

    public static void main(String[] args) {
        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Example - Read JSON to RDD")
                .master("local[2]")
                .getOrCreate();

        // read list to RDD
        String jsonPath = "data/rdd/input/employees1.json";
        JavaRDD<Row> items = spark.read().json(jsonPath).toJavaRDD();

        items.foreach(item -> {
            System.out.println(item);
        });
    }
}