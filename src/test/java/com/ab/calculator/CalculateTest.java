package com.ab.calculator;

import com.ab.calculator.config.ProjectConfig;
import com.ab.calculator.io.WriterUtilImpl;
import com.ab.calculator.service.Calculate;
import com.ab.calculator.service.CalculateImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = { CalculateImpl.class, ProjectConfig.class})
@EnableConfigurationProperties
public class CalculateTest {

    @Autowired
    Calculate calculate;

    @Test
    public void calculateValueTest() {
        String exp1 ="1+1";
        String exp2 = "1 plus 1";
        Double res  = calculate.calculateExpression(exp1);
        assertTrue(res.equals(2.0));

        res  = calculate.calculateExpression(exp2);
        assertTrue(null == res);

    }
}
