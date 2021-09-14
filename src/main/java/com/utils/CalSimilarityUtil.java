package com.utils;

import java.text.DecimalFormat;

import static com.utils.CalHamDistanceUtil.getHamDistance;

public class CalSimilarityUtil {

    public static String getSimilarity(String simhash1, String simhash2){
        //计算出海明距离
        double distance = getHamDistance(simhash1, simhash2);
//         通过海明距离计算出相似度
        double similar=0.01 * (100 - distance * 100 / 128);
        //保留两位小数
        DecimalFormat df2 = new DecimalFormat("######0.00");

        return df2.format(similar);
    }

}
