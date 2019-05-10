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

public class CalculatorRestAPITest {
    private static Logger LOG = LogManager.getLogger(CalculatorRestAPITest.class);
    private static CalculatorService serviceRest = ServiceFactory.getCalculatorService("REST");
    private static CalculateRestServiceClient clientRest = new CalculateRestServiceClient();

    @BeforeClass
    public static void setUp() {
        LOG.info("Getting port of CalculatorService");
    }

    @Test
    public void checkBodyRestServiceTest() throws SoapException, ResponseError {
        LOG.info("Messages from rest service");
        String actualBody = "[\"value1-> 9.000000;  value2-> 8.000000; operation: 'ADD'; answer-> 17.0000 \"]";
        Response response = serviceRest.getCalculate(9, 8, "ADD");
        String expectedBody = clientRest.performResponseAsString(response);
        Assert.assertEquals(expectedBody, actualBody);
    }

    @Test
    public void checkOtherOperationTest() {
        LOG.info("Check if other operation forbidden, expect 6 allow ");
        Assert.assertThrows(ResponseError.class, () -> serviceRest.getCalculate(12, 73, "SIN"));
    }
}



