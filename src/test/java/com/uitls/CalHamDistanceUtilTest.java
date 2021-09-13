package com.uitls;

import com.utils.CalHamDistanceUtil;
import com.utils.IoUtils;
import org.junit.Test;

import java.io.IOException;

import static com.utils.CalSimHashUtil.getSimHash;

public class CalHamDistanceUtilTest {

    @Test
    public void getHammingDistanceTest() throws IOException {

        int distance=0;
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_del.txt");
        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);
        //得出正常计算情况下的海明距离
        distance= CalHamDistanceUtil.getHamDistance(simhash1,simhash2);
        System.out.println("海明距离==="+distance);
        //当某个字符串为空时
        simhash1=null;
        distance= CalHamDistanceUtil.getHamDistance(simhash1,simhash2);
        System.out.println("当其中有一个simhash值为空时返回-->"+distance);
        //当两个字符串的长度不相同时
        simhash1="010";
        simhash2="0111010101010";
        distance= CalHamDistanceUtil.getHamDistance(simhash1,simhash2);
        System.out.println("当两个simhash长度不一致时返回-->"+distance);
        return;
    }

}
