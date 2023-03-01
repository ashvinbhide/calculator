package com.ab.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
public class ProjectConfig {

    @Bean
    public ExpressionParser getExpressionParser() {
        return new SpelExpressionParser();
    }

}
