package com.ab.calculator;

import com.ab.calculator.constant.Constants;
import com.ab.calculator.io.ReaderUtil;
import com.ab.calculator.io.WriterUtil;
import com.ab.calculator.service.Calculate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

@SpringBootApplication
public class CalculatorApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(CalculatorApplication.class);

    final ReaderUtil readerUtil;

    @Value("${input_file}")
    private String inputFile;

    @Value("${output_file}")
    private String outputFile;



    @Autowired
    Calculate calculate;

    @Autowired
    WriterUtil writerUtil;

    public CalculatorApplication(ReaderUtil reader) {
        this.readerUtil = reader;
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        if(args.length>2) {
            logger.error(Constants.WRONG_ARG);
            System.exit(0);
        }
        if(args.length==1) {
            inputFile = args[0];
        }

        if(args.length==2) {
            inputFile = args[0];
            outputFile= args[1];
        }
        final Stream<String> ioStream = readerUtil.getFileStream(inputFile);
        final FileWriter writer = (FileWriter) writerUtil.getFileWriter(outputFile);
        try(ioStream;writer) {

            ioStream.takeWhile(s -> !s.equals(Constants.EQUALS)).map(s -> s.trim()).forEach(s -> {
                Double res = calculate.calculateExpression(s);
                String toWrite = res == null ? Constants.ERROR + System.lineSeparator() : s + Constants.EQUALS + res + System.lineSeparator();
                writerUtil.writeToFile(writer, toWrite);
            });
        }
        logger.info(Constants.COMPLETE);
    }
}
