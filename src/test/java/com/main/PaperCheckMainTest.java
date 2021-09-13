package com.main;

import com.utils.IoUtils;
import org.junit.Test;

import java.io.IOException;

import static com.utils.CalSimHashUtil.getSimHash;
import static com.utils.CalSimilarityUtil.getSimilarity;

public class PaperCheckMainTest {
     @Test
    public void AllTest() throws IOException {
      String[] str=new String[6];
      //将要读取的文本路径放入数组中
         str[0] = IoUtils.read("C:/tests/orig.txt");
         str[1] = IoUtils.read("C:/tests/orig_0.8_add.txt");
         str[2] = IoUtils.read("C:/tests/orig_0.8_del.txt");
         str[3] = IoUtils.read("C:/tests/orig_0.8_dis_1.txt");
         str[4] = IoUtils.read("C:/tests/orig_0.8_dis_10.txt");
         str[5] = IoUtils.read("C:/tests/orig_0.8_dis_15.txt");
         String resultfilepath = "C:/tests/ans.txt";
         String simhash0=getSimHash(str[0]);
         double result=0;
         for(int i=0;i<6;i++){//逐一与原文件比较
             String simhash1=getSimHash(str[i]);
             result=getSimilarity(simhash0,simhash1);
             IoUtils.write(resultfilepath,result);
         }
    }

    @Test
    public void AddTest() throws IOException{ //原文件与add文件比较
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_add.txt");
        String resultfilepath = "C:/tests/ans.txt";
        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
        //计算出两个文章的相似度
        double result=getSimilarity(simhash1,simhash2);
        //将计算结果写入到目标文件中
        IoUtils.write(resultfilepath,result);
        return;
    }

    @Test
    public void DelTest() throws IOException{//原文件与del文件比较
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_del.txt");
        String resultfilepath = "C:/tests/ans.txt";
        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
        //计算出两个文章的相似度
        double result=getSimilarity(simhash1,simhash2);
        //将计算结果写入到目标文件中
        IoUtils.write(resultfilepath,result);
        return;
    }


    @Test
    public void Dis_1Test() throws IOException{//原文件与dis_1文件比较
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_dis_1.txt");
        String resultfilepath = "C:/tests/ans.txt";
        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
        //计算出两个文章的相似度
        double result=getSimilarity(simhash1,simhash2);
        //将计算结果写入到目标文件中
        IoUtils.write(resultfilepath,result);
        return;
    }

    @Test
    public void Dis_10Test() throws IOException{//原文件与dis_10文件比较
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_dis_10.txt");
        String resultfilepath = "C:/tests/ans.txt";
        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
        //计算出两个文章的相似度
        double result=getSimilarity(simhash1,simhash2);
        //将计算结果写入到目标文件中
        IoUtils.write(resultfilepath,result);
        return;
    }

    @Test
    public void Dis_15Test() throws IOException{//原文件与dis_15文件比较
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_dis_15.txt");
        String resultfilepath = "C:/tests/ans.txt";
        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
        //计算出两个文章的相似度
        double result=getSimilarity(simhash1,simhash2);
        //将计算结果写入到目标文件中
        IoUtils.write(resultfilepath,result);
        return;
    }

}
