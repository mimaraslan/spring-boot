package com.mimaraslan.redis;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import redis.clients.jedis.Jedis;

import java.util.List;

public class _004_SparkRedis {

    public static void main(String[] args) {

        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");

        //store data in redis list
/*
        jedis.lpush("studentList", "Katerina");
        jedis.lpush("studentList", "Lena");
        jedis.lpush("studentList", "Olga");
*/
        // Get the stored data and print it
        List<String> myList = jedis.lrange("studentList", 0, 15);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + " Stored string in redis:: " + myList.get(i));
        }


        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL data source JSON example")
                .master("local[2]")
                .getOrCreate();


        // A JSON dataset is pointed to by path.
        // The path can be either a single text file or a direc
        //
        //       tory storing text files
        Dataset<Row> people = spark.read()
                .option("timestampFormat", "yyyy/MM/dd HH:mm:ss ZZ")
                .format("json")
                .option("multiline", true)
                .json("data/rdd/input/jsonfile/employees1.json");

        // Dataset<Row> df = spark.read().json("examples/src/main/resources/people.json");

        // The inferred schema can be visualized using the printSchema() method
        System.out.println("Schema\n=======================");
        people.printSchema();

        // Creates a temporary view using the DataFrame
        people.createOrReplaceTempView("people");

        // SQL statements can be run by using the sql methods provided by spark
        Dataset<Row> namesDF = spark.sql("SELECT name, salary FROM people WHERE salary>3500 ");
        System.out.println("\n\nSQL Result\n=======================");
        namesDF.show();

        // stop spark session
        spark.stop();
    }
}