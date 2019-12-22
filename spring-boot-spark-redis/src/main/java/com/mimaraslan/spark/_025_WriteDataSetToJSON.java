package com.mimaraslan.spark;

import java.io.Serializable;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

public class _025_WriteDataSetToJSON {

    public static class Employee implements Serializable {
        public String name;
        public int salary;
    }

    public static void main(String[] args) {
        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Example - Write Dataset to JSON File")
                .master("local[2]")
                .getOrCreate();

        Encoder<Employee> employeeEncoder = Encoders.bean(Employee.class);
        String jsonPath = "data/rdd/input/employees1.json";

        Dataset<Employee> ds = spark.read()
                .format("json")
                .option("multiline", true)
                .json(jsonPath).as(employeeEncoder);

        // write dataset to JSON file
        ds.write().json("data/rdd/output/out_employees/");
    }
}