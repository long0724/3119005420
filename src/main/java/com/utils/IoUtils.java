package com.utils;

import java.io.*;

/*
读写文件的工具类
 */
public class IoUtils {

    /*
       读取文本txt文件，返回字符串
     */
    public static String read(String path) {

        //将读出的字符串用StringBuilder连接。
        StringBuilder builder = new StringBuilder();
        String text;
        File file=new File(path);
        //判断其是否为文件并且是否存在
            try{
                String encoding="UTF-8";
                if(file.isFile() && file.exists()) { //判断读取的文件是否存在和是否为文件类型
                    FileInputStream fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, encoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while ((text = bufferedReader.readLine()) != null) {
                        builder.append(text);
                    }
                    //读取流关闭
                    inputStreamReader.close();
                    bufferedReader.close();
                    fileInputStream.close();
                }
                else{
                    System.out.println("文件不存在或者读取的不是文件");
                }
            }catch(IOException e){
                System.out.println("读取文件内容出错");
                e.printStackTrace();
            }
            //返回字符串类型
        return builder.toString();
    }

      public static void write(String path, String result) {
          BufferedWriter out=null;
          try{
              out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true)));
              //写入结果并换行
              out.write(result);
              out.newLine();
          }catch (Exception e){
              System.out.println("写入失败");
              e.printStackTrace();
          }
          finally {
              try{
                  //输出流关闭
                  if (out != null) {
                      out.close();
                  }
              }catch (IOException e){
                  System.out.println("输出流关闭失败");
                  e.printStackTrace();
              }
          }
      }

}
