package com.mimaraslan;

public class c {

    static float tax_rate = 0.06F;

    public static void main(String[] args) {

        Object s1 = null + " " + null;
        String s2 = null + " " + null;

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


        int a = 10;
        int b = 10;
        System.out.println(a + b + " " + a + b);
        System.out.println("" + a + b + " " + a + b);

        System.out.println(a + b + " " + (a + b));
        System.out.println("" + a + b + " " + (a + b));





        String a1 = "Java";
        a1 += 10 + 20;
        System.out.println(a1);

        String a2 = "Java";
        a2 = a2 + 10 + 20;
        System.out.println(a2);

        String a3 = "Java";
        a3 = a3 + (10 + 20);
        System.out.println(a3);


    }
}

