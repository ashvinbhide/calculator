package com.ab.calculator.service;

import com.ab.calculator.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class CalculateImpl implements Calculate{

    Logger logger = LoggerFactory.getLogger(CalculateImpl.class);

    final ExpressionParser parser;

    public CalculateImpl(ExpressionParser parser) {
        this.parser = parser;
    }

    @Override
    public Double calculateExpression(String exp) {
        logger.info(Constants.EXPRESSION_STRING +exp);
        Double result = null;

        try {
            result = parser.parseExpression(exp).getValue(Double.class);
        }catch(Exception e) {
            e.getMessage();
        }
        return  result;
    }
}
