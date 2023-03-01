package com.ab.calculator;

import com.ab.calculator.io.ReaderUtil;
import com.ab.calculator.io.ReaderUtilImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.stream.Stream;


@SpringBootTest(classes = { ReaderUtilImpl.class })
@EnableConfigurationProperties
public class ReaderUtilTest {

    @Autowired
    ReaderUtil readerUtil;

    @Test
    public void getFileStreamTest() throws IOException {
        Stream<String> ipStream =readerUtil.getFileStream("c:/a/input.txt");
        Assert.isTrue(ipStream != null , "test case pass");
    }
}
