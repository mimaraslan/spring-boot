package com.mimaraslan.spark;

import java.io.Serializable;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import com.google.common.collect.ImmutableList;

public class _004_CustomObjectsRDD {

    public static void main(String[] args) {
        // configure spark
        SparkConf sparkConf = new SparkConf().setAppName("Print Elements of RDD")
                .setMaster("local[2]").set("spark.executor.memory","2g");

        // start a spark context
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // prepare list of objects
        List<Person> personList = ImmutableList.of(
                new Person("Katerina", 25),
                new Person("Yulya", 27));

        // parallelize the list using SparkContext
        JavaRDD<Person> perJavaRDD = sc.parallelize(personList);

        for(Person person : perJavaRDD.collect()){
            System.out.println(person.name);
        }

        sc.close();
    }
}

class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}