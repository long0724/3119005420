package com.utils;

import java.math.BigDecimal;

import static com.utils.CalHamDistanceUtil.getHamDistance;

public class CalSimilarityUtil {

    public static double getSimilarity(String simhash1, String simhash2){
        //计算出海明距离
        double distance = getHamDistance(simhash1, simhash2);
//         通过海明距离计算出相似度
        double similar=0.01 * (100 - distance * 100 / 128);
        //将计算出的double类型结果转为String类型返回
        BigDecimal temp   =   new   BigDecimal(similar);
        double   result  =   temp.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

}
