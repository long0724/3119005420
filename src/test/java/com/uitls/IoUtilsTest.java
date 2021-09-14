package com.uitls;

import com.utils.IoUtils;
import org.junit.Test;

public class IoUtilsTest {

    @Test
    public void ReadTrueTest()  { //正确读取到文件
        String str0 = IoUtils.read("C:/tests/org.txt");
        System.out.println(str0);
    }

    @Test
    public void WriteTrueTest()  {//正确写入文件
        String resultfilepath = "C:/tests/ans.txt";
        String testresult="666.66";
        IoUtils.write(resultfilepath,testresult);

    }

    @Test
    public void ReadFalseTest(){//错误读取（路径错误）
        String str0 = IoUtils.read("C:/tests/org_888.txt");
        System.out.println(str0);
    }

    @Test
    public void WriteFalseTest() {//写入错误，（路径下不存在待写入的文件）
        String resultfilepath = "C:/tests/ans999.txt";
        String testresult="999.99";
        IoUtils.write(resultfilepath,testresult);

    }
    
}
