package com.epam.labTA.web.rest;

import com.epam.labTA.web.exception.ResponseError;
import com.epam.labTA.web.soap.CalculatorService;
import com.epam.labTA.web.soap.SoapException;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.given;
import static java.util.stream.Collectors.toList;

public class CalculateRestServiceClient implements CalculatorService {

    public static final String endpoint = "http://localhost:8080/OlenkaSaloCalculatorService/calculatorRest/";
    public static Logger LOG = LogManager.getLogger(CalculateRestServiceClient.class);
    public static String PERCENTAGE = "percentage/";
    public static String MULTIPLY = "multiply/";
    public static String CALCULATE = "calculate/";
    public static String DIVIDE = "divide/";
    public static String SUBTRACT = "subtract/";
    public static String ADD = "add/";

    @Step("Step rest service for percentage num1: {} and num2: {} ...")
    public Response getPercentage(double x, double y) throws SoapException, ResponseError {
        String url = String.format(endpoint + PERCENTAGE + x + "/" + y);
        return performClientRequest(url);

    }

    @Step("Step rest service for multiply num1: {} and num2: {} ...")
    public Response getMultiply(double x, double y) throws ResponseError {
        String url = String.format(endpoint + MULTIPLY + x + "/" + y);
        return performClientRequest(url);
    }


    @Step("Calculate rest service for num1: {}, num2: {}, by method:{} ...")
    public Response getCalculate(double x, double y, String operation) throws SoapException, ResponseError {
        String url = String.format(endpoint + CALCULATE + x + "/" + y + "/" + operation);
        return performClientRequest(url);
    }

    @Step("Step rest service for divide num1: {} and num2: {} ...")
    public Response getDivide(double x, double y) throws SoapException, ResponseError {
        String url = String.format(endpoint + DIVIDE + x + "/" + y);
        return performClientRequest(url);
    }

    @Step("Step rest service for subtract num1: {} and num2: {} ...")
    public Response getSubtract(double x, double y) throws ResponseError {
        String url = String.format(endpoint + SUBTRACT + x + "/" + y);
        return performClientRequest(url);
    }

    @Step("Add for rest service num1: {}, num2: {} ...")
    public Response getAdd(double x, double y) throws ResponseError {
        String url = String.format(endpoint + ADD + x + "/" + y);
        return performClientRequest(url);
    }

    @Step("Step for perform request rest service with url: {} ...")
    public Response performClientRequest(String url) throws ResponseError {
        Response result = null;
        int stCode = given()
                .when()
                .get(url)
                .statusCode();

        if (stCode != 200) {
            throw new ResponseError(String.format("Status code of HTTP response  %s instead of 200 ", stCode));
        } else {
            result = given()
                    .when()
                    .get(url);
        }
        return result;
    }

    public String performResponseAsString(Response response) {
        ResponseBody body = response.getBody();
        return body.asString();
    }

    public double performAnswer(String output) {
        List<String> msg = Arrays.asList(output.split(";"));
        List<String> msgNew;
        double result;

        msgNew = msg.stream().
                filter(str -> str.contains("answer"))
                .map(st -> st.replaceAll(".*?([\\d.]+).*", "$1"))
                .collect(toList());

        LOG.info(msgNew);
        result = Double.parseDouble(msgNew.get(msgNew.size() - 1));
        return result;
    }

}

