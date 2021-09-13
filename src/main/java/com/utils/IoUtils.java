package com.utils;

import java.io.*;

/*
读写文件的工具类
 */
public class IoUtils {

    /*
       读取文本txt，返回字符串
     */
    public static String read(String path) throws IOException {
        StringBuilder result = new StringBuilder();
        String text=null;
        File afile=new File(path);
        //判断其是否为文件并且是否存在
        if(afile.isFile() && afile.exists()){
            try{
                String encoding="UTF-8";
                FileInputStream fileInputStream = new FileInputStream(afile);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,encoding);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while((text = bufferedReader.readLine()) != null){
                    result.append(text);
                }
                inputStreamReader.close();
                bufferedReader.close();
                fileInputStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("文件不存在或者读取的不是文件");
        }
        return result.toString();
    }

      public static void write(String path, double resultrate) throws IOException {
         String result=Double.toString(resultrate);

          BufferedWriter out=null;
          try{
              out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true)));
              out.write(result);
          }catch (Exception e){

          }
          finally {
              try{
                  out.close();
              }catch (IOException e){
                  e.printStackTrace();
              }
          }
      }

}
