package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {


    public List<Integer> getFactorOf(int n) {
        List<Integer> factors = new ArrayList<>();
         int deviser =2;
        while (n>1) {
            while(n%deviser==0) {
                factors.add(deviser);
                n/=deviser;
            }
            deviser++;
        }
        return factors;
    }




}
