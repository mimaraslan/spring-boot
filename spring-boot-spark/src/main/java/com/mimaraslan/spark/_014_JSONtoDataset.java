package com.mimaraslan.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class _014_JSONtoDataset {

    public static void main(String[] args) {
        _014_JSONtoDataset obj = new _014_JSONtoDataset();
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

        // read list to Dataset
        Dataset<Row> df = spark.read()
                .format("json")
                .option("multiline", true)
                .load(jsonPath);

// The inferred schema can be visualized using the printSchema() method
        df.show(5, 13);
        df.printSchema();
    }
}