package com.utils;

public class CalHamDistanceUtil {
//可以确定
    public static int getHamDistance(String simhash1,String simhash2){
       if(simhash1==null||simhash2==null||simhash1.length()!=simhash2.length()) return -1;
       int distance=0;
       int length=simhash1.length();
       for(int i=0;i<length;i++){
           if (simhash1.charAt(i) !=simhash2.charAt(i)) {
               distance++;
           }
       }
       return distance;
    }

}
