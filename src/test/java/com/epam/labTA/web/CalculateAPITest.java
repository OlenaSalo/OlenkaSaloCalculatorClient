package com.epam.labTA.web;


import com.epam.labTA.web.soap.Calculator;
import com.epam.labTA.web.soap.SoapException;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class CalculateAPITest {

    public static Logger LOG = LogManager.getLogger(CalculateAPITest.class);
    public static CalculatorService serviceSoap;
    public static CalculatorService serviceRest;
    private double number1 = 222;
    private double number2 = 145;
    private double actualPer = 153.1034;
    private Calculator calculatorDIV = new Calculator(number1, number2, "/");
    private Calculator calculatorMUL = new Calculator(number1, number2, "*");
    private Calculator calculatorADD = new Calculator(number1, number2, "+");
    private Calculator calculatorSUB = new Calculator(number1, number2, "-");
    private Calculator calculatorPER = new Calculator(number1, number2, "%");


    @BeforeClass
    public static void setUp() {
        LOG.info("Getting port of CalculatorService");
        serviceRest = ServiceFactory.getCalculatorService("REST");
        serviceSoap = ServiceFactory.getCalculatorService("SOAP");
    }

    @Test
    @Step("Step to verify soap calculator operation")
    public void verifyRightCalculateOperationSoap() throws SoapException, IOException {

        LOG.info("Verification of divide operation, Soap");

        Assert.assertEquals( serviceSoap.getDivide(number1, number2), serviceSoap.getCalculate(calculatorDIV));

        LOG.info("Verification of multiply operation, Soap");

        Assert.assertEquals(number1*number2, serviceSoap.getCalculate(calculatorMUL));

        LOG.info("Verification of add operation, Soap");

        Assert.assertEquals(number1+number2, serviceSoap.getCalculate(calculatorADD));

        LOG.info("Verification of subtract operation, Soap ");

        Assert.assertEquals(number1-number2, serviceSoap.getCalculate(calculatorSUB));

        LOG.info("Verification of percentage operation, Soap");

        Assert.assertEquals(actualPer, serviceSoap.getCalculate(calculatorPER));

    }

    @Test
    public void verifyRightCalculateOperationRest() throws SoapException {

        LOG.info("Verification of multiply operation, Rest");

        Assert.assertEquals(serviceRest.getMultiply(number1, number2), number1*number2);

        LOG.info("Verification of add operation, Rest");

        Assert.assertEquals(serviceRest.getAdd(number1, number2), number1+number2);

        LOG.info("Verification of subtract operation, Rest");

        Assert.assertEquals(serviceRest.getSubtract(number1, number2), number1-number2);

        LOG.info("Verification of percentage operation, Rest");

        Assert.assertEquals(serviceRest.getPercentage(number1, number2), actualPer);

    }

    @Test
    public void verifyForbiddenZeroDivision() throws SoapException{
        LOG.info("Forbidden divide for zero verification, Rest service");

        Assert.assertThrows(RuntimeException.class, () -> serviceRest.getDivide(4,0));

    }

    @Test
    public void checkRoundTo4Places() throws SoapException{
        LOG.info("Round of fractional number up to 4 characters, Soap service");

        double num1 = 5;
        double num2= 6;
        double actualResult = 0.8333;

        Assert.assertEquals(serviceSoap.getDivide(num1, num2), actualResult);

        LOG.info("Round of fractional number up to 4 characters, Rest service");

        Assert.assertEquals(serviceRest.getDivide(num1, num2), actualResult);
    }

    @Test
    @Step("Step to verify that calculator works with five method: add, divide, percentage, subtract and multiply")
    public void verifyOtherOperationNotCalculate() throws SoapException
    {
        LOG.info("The other calculation operation not execute");

        double num1 = 7.0;
        double num2 = 8.0;
        double expectedResult = Math.pow(num1, num2);

        Calculator calc = new Calculator(7, 8 , "pow");

        Assert.assertNotEquals(serviceSoap.getCalculate(calc) , expectedResult);
    }

    @Test
    public void verifyNegativeNumber() throws SoapException{
        LOG.info("Verification of negative number, Soap service");

        double num1 = 6;
        double num2 = 11;

        double expectedResult = -5;

        Assert.assertEquals(serviceSoap.getSubtract(num1, num2), expectedResult);

        LOG.info("Verification of negative number, Rest service");
        Assert.assertEquals(serviceRest.getSubtract(num1, num2), expectedResult);
    }

}
