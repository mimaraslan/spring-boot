package com.mimaraslan.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class _028_JSONsqlExample {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL data source JSON example")
                .master("local[2]")
                .getOrCreate();

        // A JSON dataset is pointed to by path.
        // The path can be either a single text file
        Dataset<Row> people = spark.read().format("json").option("multiline", true).json("data/rdd/input/jsonfile/employees1.json");

        // The inferred schema can be visualized using the printSchema() method
        System.out.println("Schema\n=======================");
        people.printSchema();

        // Creates a temporary view using the DataFrame
        people.createOrReplaceTempView("people");

        // SQL statements can be run by using the sql methods provided by spark
        Dataset<Row> namesDF = spark.sql("SELECT name, salary FROM people WHERE salary > 3500 ");
        System.out.println("\n\nSQL Result\n=======================");
        namesDF.show();

        spark.stop();
    }
}