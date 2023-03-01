package com.ab.calculator.io;

import java.io.IOException;
import java.io.Writer;

public interface WriterUtil {

    Writer getFileWriter(String outputFile) throws IOException;
    boolean writeToFile(Writer writer, String data);
    //void close(Writer writer);
}
