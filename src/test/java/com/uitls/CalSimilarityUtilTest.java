package com.uitls;

import com.utils.IoUtils;
import org.junit.Test;

import java.io.IOException;

import static com.utils.CalSimHashUtil.getSimHash;
import static com.utils.CalSimilarityUtil.getSimilarity;

public class CalSimilarityUtilTest {

   @Test
    public void CalSimilarityTest() throws IOException {
      //计算两篇文章的相似度
       String str0 = IoUtils.read("C:/tests/org.txt");
       String str1 = IoUtils.read("C:/tests/orig_0.8_del.txt");

       String simhash1=getSimHash(str0);
       String simhash2=getSimHash(str1);

       double result=getSimilarity(simhash1,simhash2);
       System.out.println("相似度为==="+result);
   }

}
