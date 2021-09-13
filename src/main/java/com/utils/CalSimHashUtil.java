package com.utils;


import com.hankcs.hanlp.HanLP;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CalSimHashUtil {

/*
MessageDigest所在包java.security是java提供的加密API
 */
static char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static String getHash(String str){
        if (str == null || str.length() == 0) {
            return null;
        } else {
            try{
                MessageDigest md5 = MessageDigest.getInstance("MD5");//申明使用MD5算法

                md5.update(str.getBytes());
                return hexStrToBinaryStr(byte2str(md5.digest()));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String hexStrToBinaryStr(String hexString) {

        if (hexString == null || hexString.equals("")) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        // 将每一个十六进制字符分别转换成一个四位的二进制字符
        for (int i = 0; i < hexString.length(); i++) {
            String indexStr = hexString.substring(i, i + 1);
            String binaryStr = Integer.toBinaryString(Integer.parseInt(indexStr, 16));
            while (binaryStr.length() < 4) {
                binaryStr = "0" + binaryStr;
            }
            sb.append(binaryStr);
        }

        return sb.toString();
    }

    private static String byte2str(byte []bytes){
        int len = bytes.length;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < len; i++) {
            byte byte0 = bytes[i];
            result.append(hex[byte0 >>> 4 & 0xf]);   // 见下面解释。
            result.append(hex[byte0 & 0xf]);
        }
        return result.toString();
    }




    public static String getSimHash(String str){

        int v[] = new int[128];
        for(int i=0;i<128;i++)
            v[i]=0;

        List<String> keywordList = HanLP.extractKeyword(str, str.length());//取出所有关键词
        int size=keywordList.size();

        for(int i=0;i<size;i++){
            String str_hash=getHash(keywordList.get(i));
            if(str_hash.length() < 128){
                int que = 128 - str_hash.length();
                for(int j=0;j<que;j++){
                    str_hash = "0" + str_hash;
                }
            }
            //System.out.println(str_hash);//输出该词的128位MD5哈希值
            char str_hash_fb[]=str_hash.toCharArray();//将该词的哈希值转为数组，方便检查

            for(int j=0;j<v.length;j++){
                if(str_hash_fb[j] == '1'){
                    v[j]++;//Hash_SZ中，0是最高位，依次排低
                }else{
                    v[j]--;
                }
            }
        }
        //将数组中的SimHash值降维，并以字符串形式返回
        String SimHash_number="";//存储SimHash值
        for(int i=0;i<v.length;i++){
            if(v[i]<=0)//小于等于0，就取0
                SimHash_number += "0";
            else//大于0，就取1
                SimHash_number += "1";
        }

        return SimHash_number;
    }

}
