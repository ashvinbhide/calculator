package com.ab.calculator.io;

import com.ab.calculator.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class ReaderUtilImpl implements ReaderUtil {

    Logger logger = LoggerFactory.getLogger(ReaderUtilImpl.class);

    @Override
    public Stream<String> getFileStream(String filename) throws IOException {
        logger.info(Constants.INPUT_FILE+filename);
        return Files.lines(Paths.get(filename));
    }
}
