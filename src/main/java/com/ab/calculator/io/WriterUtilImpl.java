package com.ab.calculator.io;

import com.ab.calculator.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Service
public class WriterUtilImpl implements WriterUtil{

    Logger logger = LoggerFactory.getLogger(WriterUtilImpl.class);

    @Value("${append_output}")
    private boolean appendOutput;

    @Override
    public Writer getFileWriter(String outputFile) throws IOException {
        logger.info(Constants.OUTPUT_FILE+outputFile);
        return new FileWriter(outputFile,appendOutput);
    }

    public boolean writeToFile(Writer writer, String data) {
        try {
            writer.write( data);
            return  true;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
