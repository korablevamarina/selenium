package org.example;

public class Lesson4 {
    public static double calcTriangleSq(int a, int b, int c){
       double p = (a + b + c)/2;
       double S = p * (p - a) * (p - b) * (p - c);
       return Math.sqrt(S);
    }
}
