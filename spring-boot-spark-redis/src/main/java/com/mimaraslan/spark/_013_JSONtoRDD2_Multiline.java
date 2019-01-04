package com.mimaraslan.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class _013_JSONtoRDD2_Multiline {

    public static void main(String[] args) {
        _013_JSONtoRDD2_Multiline obj = new _013_JSONtoRDD2_Multiline();
        obj.start();
    }

    private void start() {

        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Example - Read JSON to RDD")
                .master("local[2]")
                .getOrCreate();

        String jsonPath = "data/rdd/input/employees1.json";

        // read list to RDD
        JavaRDD<Row> items = spark.read().format("json").option("multiline", true).json(jsonPath).toJavaRDD();

        items.foreach(item -> {
            System.out.println(item);
        });

    }
}