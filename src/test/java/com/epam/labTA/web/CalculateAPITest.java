package com.epam.labTA.web;

import com.epam.labTA.web.exception.ResponseError;
import com.epam.labTA.web.rest.CalculateRestServiceClient;
import com.epam.labTA.web.soap.CalculatorService;
import com.epam.labTA.web.soap.SoapException;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateAPITest {

    public static Logger LOG = LogManager.getLogger(CalculateAPITest.class);
    public static CalculatorService serviceRest;
    public static CalculateRestServiceClient restClient;
    public static Response response = null;
    public static String responseResult;
    public static double value1 = 105.0;
    public static double value2 = 16.0;

    @BeforeClass
    public static void setUp() {
        LOG.info("Getting port of CalculatorService");
        serviceRest = ServiceFactory.getCalculatorService("REST");
        restClient = new CalculateRestServiceClient();
    }

    @Test
    public void verifyRightDivideOperation() throws SoapException, ResponseError {
        LOG.info("Verification of divide operation");
        double actual = value1 / value2;
        response = serviceRest.getDivide(value1, value2);
        responseResult = restClient.performResponseAsString(response);
        Assert.assertEquals(restClient.performAnswer(responseResult), actual);
    }

    @Test
    public void verifyRightSubtractOperation() throws SoapException, ResponseError {
        LOG.info("Verification of subtract operation, Rest");
        double actual = value1 - value2;
        response = serviceRest.getSubtract(value1, value2);
        responseResult = restClient.performResponseAsString(response);
        Assert.assertEquals(restClient.performAnswer(responseResult), actual);
    }

    @Test
    public void verifyRightMultiplyOperation() throws SoapException, ResponseError {
        LOG.info("Verification of multiply operation, Rest");
        double actual = value1 * value2;
        response = serviceRest.getMultiply(value1, value2);
        responseResult = restClient.performResponseAsString(response);
        Assert.assertEquals(restClient.performAnswer(responseResult), actual);
    }

    @Test
    public void verifyRightPercentageOperation() throws SoapException, ResponseError {
        LOG.info("Verification of percentage operation, Rest");
        double actual = (value1 / value2) * 100;
        response = serviceRest.getPercentage(value1, value2);
        responseResult = restClient.performResponseAsString(response);
        Assert.assertEquals(restClient.performAnswer(responseResult), actual);
    }

    @Test
    public void verifyRightAddOperation() throws SoapException, ResponseError {
        LOG.info("Verification of add operation, Rest");
        double actual = value1 + value2;
        response = serviceRest.getAdd(value1, value2);
        responseResult = restClient.performResponseAsString(response);
        Assert.assertEquals(restClient.performAnswer(responseResult), actual);
    }

    @Test
    public void verifyRightCalculateMethod() throws SoapException, ResponseError {
        LOG.info("Verification calculate method, Rest");
        double actual = value1 + value2;
        response = serviceRest.getCalculate(value1, value2, "ADD");
        responseResult = restClient.performResponseAsString(response);
        Assert.assertEquals(restClient.performAnswer(responseResult), actual);
    }

    @Test
    public void verifyForbiddenZeroDivision() {
        LOG.info("Forbidden divide for zero verification, Rest service");
        Assert.assertThrows(ResponseError.class, () -> serviceRest.getDivide(4, 0));
    }

    @Test
    public void checkRoundTo4Places() throws SoapException, ResponseError {
        double arg0 = 5.0;
        double arg1 = 6.0;
        double actualResult = 0.8333;
        LOG.info("Round of fractional number up to 4 characters, Rest service");
        response = serviceRest.getDivide(arg0, arg1);
        responseResult = restClient.performResponseAsString(response);
        Assert.assertEquals(restClient.performAnswer(responseResult), actualResult);
    }

    @Test
    public void verifyNegativeNumber() throws SoapException, ResponseError {
        double arg0 = 6.0;
        double arg1 = 11.0;
        double actualResult = -5.0;
        response = serviceRest.getSubtract(arg0, arg1);
        responseResult = restClient.performResponseAsString(response);
        LOG.info("Verification of negative number, Rest service");
        Assert.assertNotEquals(restClient.performAnswer(responseResult), actualResult);
    }

}
