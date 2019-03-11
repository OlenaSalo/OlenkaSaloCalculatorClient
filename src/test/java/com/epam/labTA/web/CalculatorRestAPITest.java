package com.epam.labTA.web;

import com.epam.labTA.web.rest.CalculateRestServiceClient;
import com.epam.labTA.web.soap.SoapException;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static com.epam.labTA.web.rest.CalculateRestServiceClient.*;


public class CalculatorRestAPITest {
    private static Logger LOG = LogManager.getLogger(CalculatorRestAPITest.class);
    private CalculateRestServiceClient service = new CalculateRestServiceClient();


    @Test
    public void checkMessagefromRestServiceTest() throws SoapException {
        LOG.info("Messages from rest service");
        String url = String.format("%s/%s/%s/%s",  CALCULATE, 12, 3, "+");

        String actualString = "[\"value1-> 12,000000;  value2-> 3,000000; operation: '+'; answer-> 15,0000 \"]";

        Assert.assertEquals( service.performRequest(url), actualString);
    }

    @Test
    @Step("Step check status code for calculate endpoints")
    public void checkStatusForEndpointRestTest() {
        LOG.info("Check status code for endpoint CALCULATE");
        String str = endpoint + CALCULATE + "/45" + "/11" + "/*";
        Response response = get(str);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }



}
