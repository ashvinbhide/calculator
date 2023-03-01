package com.ab.calculator.io;

import java.io.IOException;
import java.util.stream.Stream;

public interface ReaderUtil {

    Stream<String> getFileStream(String filename) throws IOException;
}
