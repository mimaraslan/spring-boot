package com.mimaraslan.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.*;
import java.util.*;

public class _005_ProducerBatchApp {

    public static void main(String[] args) {

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("buffer.memory", 33554432);
        props.put("compression.type", "none");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("client.id", "");
        props.put("linger.ms", 0);
        props.put("max.block.ms", 60000);
        props.put("max.request.size", 1048576);
        props.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        props.put("request.timeout.ms", 30000);
        props.put("timeout.ms", 30000);
        props.put("max.in.flight.requests.per.connection", 5);
        props.put("retry.backoff.ms", 5);

        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);
        DateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        String topic = "my-topic";

        try {
            int batchNumber = 1;
            int counter = 0;
            while (true) {
                do {
                    myProducer.send(
                            new ProducerRecord<String, String>(topic, String.format("Batch: %s || %s", Integer.toString(batchNumber), dtFormat.format(new Date())))
                    );
                    counter++; // Increase record counter...

                    // use if you want to add latency between record sends
                    // Thread.sleep(500);

                    // use if you want to add random latency between record sends
                    // Thread.sleep(new Random(1000).nextLong());

                } while (counter < 10); // Number of records sent in a batch...
                counter = 0; // Reset the record counter...

                // Set how long before a new batch is sent...
                Thread.sleep(500);

                // use if you want to randomize the time between batch record sends
                // Thread.sleep(new Random(5000).nextLong());

                batchNumber++; // Increase the batch number...
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myProducer.close();
        }

    }
}