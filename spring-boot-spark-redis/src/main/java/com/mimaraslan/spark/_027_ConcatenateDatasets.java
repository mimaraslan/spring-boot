package com.mimaraslan.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class _027_ConcatenateDatasets {

    public static void main(String[] args) {
        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Example - Append/Concatenate two Datasets")
                .master("local[2]")
                .getOrCreate();

        Dataset<Row> ds1 = spark.read().format("json").option("multiline", true).json("data/rdd/input/employees1.json");
        Dataset<Row> ds2 = spark.read().format("json").option("multiline", true).json("data/rdd/input/employees2.json");

        // print dataset
        System.out.println("Dataset 1\n==============");
        ds1.show();
        System.out.println("Dataset 2\n==============");
        ds2.show();

        // concatenate datasets
        Dataset<Row> ds3 = ds1.union(ds2);

        System.out.println("Dataset 3 = Dataset 1 + Dataset 2\n==============================");
        ds3.show();

        spark.stop();
    }
}