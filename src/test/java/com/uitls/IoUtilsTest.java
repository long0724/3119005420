package com.uitls;

import com.utils.IoUtils;
import org.junit.Test;

import java.io.IOException;

public class IoUtilsTest {

    @Test
    public void ReadTrueTest() throws IOException { //正确读取到文件
        String str0 = IoUtils.read("C:/tests/org.txt");
        System.out.println(str0);
    }

    @Test
    public void WriteTrueTest() throws IOException {//正确写入文件
        String resultfilepath = "C:/tests/ans.txt";
        double testresult=666.66;
        IoUtils.write(resultfilepath,testresult);
        return;
    }

    @Test
    public void ReadFalseTest()throws IOException{//错误读取（路径错误）
        String str0 = IoUtils.read("C:/tests/org_888.txt");
        System.out.println(str0);
    }

    @Test
    public void WriteFalseTest() throws IOException{//写入错误，（路径下不存在待写入的文件）
        String resultfilepath = "C:/tests/ans999.txt";
        double testresult=999.99;
        IoUtils.write(resultfilepath,testresult);
        return;
    }
    
}
