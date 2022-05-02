package com.mimaraslan;

public class A {

    static float tax_rate = 0.06F;

    public static void main(String[] args) {

        // Burada sıradan düz bir atama referansları String pool'da aynı.
        String s1 = "Java";
        String s2 = "Java";
        System.out.println((s1 == s2) ? "true" : "false");//true
        System.out.println((s1.equals(s2)) ? "true" : "false");//true
        // equals sadece değerlere bakıyor.
        // == hem değerlere hem de referanslara bakıyor.

        String s3 = new String("Java");
        String s4 = new String("Java");
        System.out.println((s3 == s4) ? "true" : "false"); //false
        System.out.println((s3.equals(s4)) ? "true" : "false");//true

        // Burada intern metodu referansları String pool'da aynı yapıyor.
        String s5 = new String("Java").intern();
        String s6 = new String("Java").intern();
        System.out.println((s5 == s6) ? "true" : "false"); //true
        System.out.println((s5.equals(s6)) ? "true" : "false");//true




    }
}

