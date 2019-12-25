package com.mimaraslan.spark;

import java.io.Serializable;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

public class _024_JSONtoDataSet {

    public static class Employee implements Serializable {
        public String name;
        public int salary;
    }

    public static void main(String[] args) {
        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("Read JSON File to DataSet")
                .master("local[2]")
                .getOrCreate();

        // Java Bean (data class) used to apply schema to JSON data
        Encoder<Employee> employeeEncoder = Encoders.bean(Employee.class);

        String jsonPath = "data/rdd/input/employees1.json";

        // read JSON file to Dataset
        Dataset<Employee> ds = spark.read()
                .format("json")
                .option("multiline", true)
                .json(jsonPath).as(employeeEncoder);
        ds.show();
        // ds.show(3, 2);
    }
}