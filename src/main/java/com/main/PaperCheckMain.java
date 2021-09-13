package com.main;

import com.utils.IoUtils;
import java.io.IOException;
import static com.utils.CalSimHashUtil.getSimHash;
import static com.utils.CalSimilarityUtil.getSimilarity;

public class PaperCheckMain {
    public static void main(String[] args)throws IOException{
        //args[0],args[1]分别是原文和校验文章的路径
//        String str0 = IoUtils.read(args[0]);
//        String str1 = IoUtils.read(args[1]);
//        //args[2]是结果输出文件的路径
//        String str2 = args[2];
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_del.txt");
        String resultfilepath = "C:/tests/ans.txt";
        //分别计算两个文本各自的海明码
        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
//        System.out.println("simhash1===="+simhash1);
//        System.out.println("simhash2===="+simhash2);
        //计算出两个文章的相似度
        double result=getSimilarity(simhash1,simhash2);
        //将计算结果写入到目标文件中
        IoUtils.write(resultfilepath,result);
        return;

    }
}
