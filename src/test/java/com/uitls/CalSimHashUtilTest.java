package com.uitls;

import com.utils.CalSimHashUtil;
import com.utils.IoUtils;
import org.junit.Test;

import java.io.IOException;

import static com.utils.CalSimHashUtil.getSimHash;

public class CalSimHashUtilTest {

    @Test
    public void getHashTest() throws IOException {
        //用某些字符串和空串测试
        String[] str =new String[]{"一位","真正的","作家",""};
        for(int i=0;i<str.length;i++){
            String hash = CalSimHashUtil.getHash(str[i]);
            //返回某个字符串计算得出的hash值
            System.out.println(str[i]+"对应的hash-->"+hash);
        }
        return;
    }

    @Test
    public void getSimHashTest() throws IOException {
        //计算两个文件的simhash值
        String str0 = IoUtils.read("C:/tests/org.txt");
        String str1 = IoUtils.read("C:/tests/orig_0.8_del.txt");

        String simhash1=getSimHash(str0);
        String simhash2=getSimHash(str1);

        System.out.println("原文的simhash==="+simhash1);
        System.out.println("被校验文章的simhash=="+simhash2);
    }




}
