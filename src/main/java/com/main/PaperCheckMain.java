package com.main;

import com.utils.IoUtils;
import java.io.IOException;
import static com.utils.CalSimHashUtil.getSimHash;
import static com.utils.CalSimilarityUtil.getSimilarity;

public class PaperCheckMain {
    public static void main(String[] args)throws IOException{
        String str0 = IoUtils.read(args[0]);
        String str1 = IoUtils.read(args[1]);
        String resultFileName = args[2];

        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
        System.out.println("simhash1===="+simhash1);
       System.out.println("simhash2===="+simhash2);
        double result=getSimilarity(simhash1,simhash2);
        IoUtils.write(resultFileName,result);
        return;

    }
}
