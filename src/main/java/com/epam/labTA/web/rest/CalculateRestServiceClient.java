package com.epam.labTA.web.rest;

import com.epam.labTA.web.CalculatorService;
import com.epam.labTA.web.soap.Calculator;
import com.epam.labTA.web.soap.SoapException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class CalculateRestServiceClient implements CalculatorService {

    public static Logger LOG = LogManager.getLogger(CalculateRestServiceClient.class);

    public static final String endpoint = "http://localhost:8080/OlenkaSaloCalculatorService/calculatorRest/";
    public static String PERCENTAGE = "/percentage";
    public static String MULTIPLY = "/multiply";
    public static String CALCULATE = "calculate";
    public static String DIVIDE = "/divide";
    public static String SUBTRACT = "/subtract";
    public static String ADD = "/add";
    public static Client client;
    private static  ClientConfig config;
    private static ClientResponse clientResponse;
    private static WebResource service ;

    static {
         config = new DefaultClientConfig();
         client = Client.create(config);
         service =  client.resource(UriBuilder.fromUri(endpoint).build());
    }

    @Step("Step rest service for percentage num1: {} and num2: {} ...")
    public double getPercentage(double x, double y) throws SoapException {
       String url = String.format("%s/%s/%s",PERCENTAGE, x, y);
        return performAnswer(performRequest(url));

    }

    @Step("Step rest service for multiply num1: {} and num2: {} ...")
    public double getMultiply(double x, double y) {
        String url = String.format("%s/%s/%s",MULTIPLY, x, y);
        return performAnswer(performRequest(url));
    }

    @Step("Step rest service for divide num1: {} and num2: {} ...")
    public double getDivide(double x, double y) throws SoapException {
        String url = String.format("%s/%s/%s",DIVIDE, x, y);
        return performAnswer(performRequest(url));
    }

    @Step("Step rest service for subtract num1: {} and num2: {} ...")
    public double getSubtract(double x, double y)  {
        String url = String.format("%s/%s/%s",SUBTRACT, x, y);
        return performAnswer(performRequest(url));
    }


    @Override
    @Step("Calculate rest service for num1: {}, num2: {}, by method:{} ...")
    public double getCalculate(Calculator calculator) throws SoapException {
        String url = String.format("%s/%s/%s",SUBTRACT, calculator.getNum1(), calculator.getNum2(), calculator.getOperation());
        return performAnswer(performRequest(url));
    }

    @Step("Add for rest service num1: {}, num2: {}, by method:{} ...")
    public double getAdd(double x, double y) {
        String url = String.format("%s/%s/%s",ADD, x, y);
        return performAnswer(performRequest(url));
    }


    @Step("Step for perform request rest service...")
    public String performRequest(String responce)  {
        clientResponse = service
                .path(responce)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        if(clientResponse.getStatus() != 200) {
            throw new RuntimeException(String.format("Failed with HTTP Error code", clientResponse));
        }
        return clientResponse.getEntity(String.class);
    }

    public double performAnswer(String output)
    {
        List<String> msg = Arrays.asList(output.split(";"));
        List<String> msgNew;
        double result;

        msgNew = msg.stream().
                filter(str -> str.contains("answer"))
                .map(st -> st.replaceAll("[^0-9,]", ""))
                .map(s -> s.replaceAll(",", "."))
                .collect(toList());

        result = Double.parseDouble(msgNew.get(msgNew.size()-1));
        return result;
    }

}

