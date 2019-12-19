package com.mimaraslan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Arrays;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... arg0) throws Exception {

        System.out.println("\nDataset Ramdom: ");
        int[][] dataset2 = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                dataset2[i][j] = (int) (Math.random() * 11) + 1;
            }
        }
        for (int k = 0; k < 10; k++) {
            for (int l = 0; l < 2; l++) {
                System.out.print(dataset2[k][l] + "\t");
            }
            System.out.println();
        }

        int dataset[][] = {
                {2, 1},
                {5, 2},
                {2, 2},
                {4, 1},
                {4, 3},
                {7, 5},
                {3, 6},
                {5, 7},
                {1, 4},
                {4, 1}
        };


        int i, j, k = 2;

        int part1[][] = new int[10][2];
        int part2[][] = new int[10][2];

        float mean1[][] = new float[1][2];
        float mean2[][] = new float[1][2];

        int sum11 = 0, sum12 = 0, sum21 = 0, sum22 = 0;
        double dist1, dist2;
        int i1 = 0, i2 = 0, itr = 0;

        // Printing the dataset
        System.out.println("\nDataset: ");
        for (i = 0; i < 10; i++) {
            System.out.println(dataset[i][0] + "\t" + dataset[i][1]);
        }

        System.out.println("\nNumber of partitions: " + k);

        // Assuming (2,3) and (5,6) are random means
        mean1[0][0] = 2;
        mean1[0][1] = 3;
        mean2[0][0] = 5;
        mean2[0][1] = 6;

        float temp1[][] = new float[1][2], temp2[][] = new float[1][2];

        // Loop till the new mean and previous mean are same
        while (!Arrays.deepEquals(mean1, temp1) || !Arrays.deepEquals(mean2, temp2)) {

            // Empting the partitions
            for (i = 0; i < 10; i++) {
                part1[i][0] = 0;
                part1[i][1] = 0;
                part2[i][0] = 0;
                part2[i][1] = 0;
            }

            i1 = 0;
            i2 = 0;

            // Finding distance between mean and data point and store the data point in the corresponding partition
            for (i = 0; i < 10; i++) {
                dist1 = Math.sqrt(Math.pow(dataset[i][0] - mean1[0][0], 2) + Math.pow(dataset[i][1] - mean1[0][1], 2));
                dist2 = Math.sqrt(Math.pow(dataset[i][0] - mean2[0][0], 2) + Math.pow(dataset[i][1] - mean2[0][1], 2));

                if (dist1 < dist2) {
                    part1[i1][0] = dataset[i][0];
                    part1[i1][1] = dataset[i][1];

                    i1++;
                } else {
                    part2[i2][0] = dataset[i][0];
                    part2[i2][1] = dataset[i][1];

                    i2++;
                }
            }

            // Storing the previous mean
            temp1[0][0] = mean1[0][0];
            temp1[0][1] = mean1[0][1];
            temp2[0][0] = mean2[0][0];
            temp2[0][1] = mean2[0][1];

            // Finding new mean for new partitions
            sum11 = 0;
            sum12 = 0;
            sum21 = 0;
            sum22 = 0;

            for (i = 0; i < i1; i++) {
                sum11 += part1[i][0];
                sum12 += part1[i][1];
            }
            for (i = 0; i < i2; i++) {
                sum21 += part2[i][0];
                sum22 += part2[i][1];
            }
            mean1[0][0] = (float) sum11 / i1;
            mean1[0][1] = (float) sum12 / i1;
            mean2[0][0] = (float) sum21 / i2;
            mean2[0][1] = (float) sum22 / i2;

            itr++;
        }

        System.out.println("\nFinal Partition: ");

        System.out.println("Part1:");
        for (i = 0; i < i1; i++) {
            System.out.println(part1[i][0] + "\t" + part1[i][1]);
        }

        System.out.println("\nPart2:");
        for (i = 0; i < i2; i++) {
            System.out.println(part2[i][0] + "\t" + part2[i][1]);
        }

        System.out.println("\nFinal Mean: ");
        System.out.println("Mean1 : " + mean1[0][0] + "\t" + mean1[0][1]);
        System.out.println("Mean2 : " + mean2[0][0] + "\t" + mean2[0][1]);
        System.out.println("\nTotal Iteration: " + itr);

    }

}
