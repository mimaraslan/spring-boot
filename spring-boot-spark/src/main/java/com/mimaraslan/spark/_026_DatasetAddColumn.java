package com.mimaraslan.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

public class _026_DatasetAddColumn {

    public static void main(String[] args) {
        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Example - Add a new Column to Dataset")
                .master("local[2]")
                .getOrCreate();

        String jsonPath = "data/rdd/input/employees1.json";

        Dataset<Row> ds = spark.read()
                .format("json")
                .option("multiline", true)
                .json(jsonPath);


        // dataset before adding enw column
        ds.show();

        // add column to ds
        Dataset<Row> newDs = ds.withColumn("new_col", functions.lit(1));

        // print dataset after adding new column
        newDs.show();

        spark.stop();
    }
}