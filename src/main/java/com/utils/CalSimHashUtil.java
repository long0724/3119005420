package com.utils;

import com.hankcs.hanlp.HanLP;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

public class CalSimHashUtil {

    //用于计算hash值所用到的函数
    static char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static String getHash(String str){
        //判断输入的字符是否为空
        if (str == null || str.length() == 0) {
            return null;
        } else {
            try{
                //实例化一个MessageDigest对象，通过提供的静态的getInstance方法
                //MessageDigest所在包java.security是java提供的加密API
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                //使用MD5算法实现对输入字符串的处理
                md5.update(str.getBytes());
                //返回每个词计算后的hash值
                return hexStrToBinaryStr(byte2str(md5.digest()));
            }catch(Exception e){
                System.out.println("哈希值生成失败");
                e.printStackTrace();
            }
        }
        return null;
    }

    //将32个16进制数转为128位二进制数
      public static String hexStrToBinaryStr(String hexString) {
         //首先判断是否为空
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        int length=hexString.length();
        // 将每一个十六进制字符分别转换成一个四位的二进制字符
        for (int i = 0; i < length; i++) {
            //取出16进制数
            String indexStr = hexString.substring(i, i + 1);
            String binaryStr = Integer.toBinaryString(Integer.parseInt(indexStr, 16));
            //如果不足4位就补足
            while (binaryStr.length() < 4) {
                binaryStr = "0" + binaryStr;
            }
            buffer.append(binaryStr);
        }
        return buffer.toString();
    }

    //将byte数组转化为32个16进制数
    private static String byte2str(byte []bytes){
        int length = bytes.length;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            byte byte0 = bytes[i];
            //每一个字节生成两个16进制数
            result.append(hex[byte0 >>> 4 & 0xf]);
            result.append(hex[byte0 & 0xf]);
        }
        return result.toString();
    }


    public static String getSimHash(String str){
        //先创建一个存储SimHash值的128数组，并初始化为0
        int v[] = new int[128];
        Arrays.fill( v, 0);
        //使用Hanlp中的extractKeyword提取出关键字
        //HanLP是一系列模型与算法组成的NLP工具包，目标是普及自然语言处理在生产环境中的应用
        List<String> keywordList = HanLP.extractKeyword(str, str.length());
        int size=keywordList.size();
        //计算字符串的SimHash值
        for(int i=0;i<size;i++){
            //计算每一个词的Hash值
            String hashvalue=getHash(keywordList.get(i));
            //保证它是128位的二进制
            if(hashvalue.length() < 128){
                int que = 128 - hashvalue.length();
                for(int j=0;j<que;j++){
                    //补足128位
                    hashvalue = "0" + hashvalue;
                }
            }
            //将该词的哈希值转为数组
            char str_hash[]=hashvalue.toCharArray();
            //对每个词的Hash值,如果是1的话加上该词的权重，0的话减去该词的权重
            for(int j=0;j<v.length;j++){
                if(str_hash[j] == '1'){
                    v[j]++;
                }else{
                    v[j]--;
                }
            }
        }
        //将数组中的SimHash值降维，并以字符串形式返回
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<v.length;i++){
            if(v[i]<=0)//小于等于0，就取0
                builder.append("0");
            else//大于0，就取1
                 builder.append("1");
        }
        return builder.toString();
    }

}
