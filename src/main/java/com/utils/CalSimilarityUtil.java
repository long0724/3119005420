package com.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static com.utils.CalHamDistanceUtil.getHamDistance;

public class CalSimilarityUtil {

    public static double getSimilarity(String simhash1, String simhash2){
        double distance = getHamDistance(simhash1, simhash2);
//         通过海明距离计算出相似度，并返回
        double f=0.01 * (100 - distance * 100 / 128);
        BigDecimal b   =   new   BigDecimal(f);
        double   result  =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
          return result;
    }

}
