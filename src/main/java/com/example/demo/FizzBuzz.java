package com.example.demo;

public class FizzBuzz {
    public static String get(int i) {

        if(i>0 && i%3==0) {
            return "FIZZ" ;
        }
        if(i>0 && i%5==0)
            return "BUZZ";



        return String.valueOf(i);
    }
}
