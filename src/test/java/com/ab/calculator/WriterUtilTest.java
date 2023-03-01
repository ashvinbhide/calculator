package com.ab.calculator;

import com.ab.calculator.io.WriterUtil;
import com.ab.calculator.io.WriterUtilImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = { WriterUtilImpl.class })
@EnableConfigurationProperties
public class WriterUtilTest {

    @Autowired
    WriterUtil writerUtil;

    @Test
    public void getFileWriterTest() throws IOException {
        String path = "./src/test/resources/output.txt";
        FileWriter writer = (FileWriter) writerUtil.getFileWriter(path);
        Assert.isTrue(null != writer,"Test case successful");
        writer.close();
        path = "./src/test/resources";
        String fileName = "output.txt";

        File file = new File(path, fileName);

        assertTrue(file.exists());
    }

    @Test
    public void writeToFileTest() throws IOException {
        try {
            String path = "./src/test/resources/output.txt";
            FileWriter writer = (FileWriter) writerUtil.getFileWriter(path);
            writerUtil.writeToFile(writer, "this is dummy data");
            writer.close();
            Assert.isTrue(null != writer, "Test case successful");
        }catch (Exception e) {
            assertTrue(false);
        }
    }
}
