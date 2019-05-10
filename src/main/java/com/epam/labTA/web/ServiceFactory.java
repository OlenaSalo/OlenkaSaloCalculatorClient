package com.epam.labTA.web;

import com.epam.labTA.web.rest.CalculateRestServiceClient;
import com.epam.labTA.web.soap.CalculatorService;
import com.epam.labTA.web.soap.CalculatorServiceImpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceFactory {

    public static final String REST = "REST";
    public static final String SOAP = "SOAP";
    private static Logger LOG = LogManager.getLogger(ServiceFactory.class);

    public static CalculatorService getCalculatorService(String serviceChoice) {
        LOG.info("getCalculator Service factory method");

        CalculatorService service;
        if (serviceChoice.equals(REST)) {
            LOG.info("Creating Rest calculator service client");
            service = new CalculateRestServiceClient();
        } else if (serviceChoice.equals(SOAP)) {
            LOG.info("Creating Soap calculator service client");
            service = new CalculatorServiceImpService().getCalculatorServiceImpPort();
        } else {
            LOG.info("Wrong input");
            throw new RuntimeException();
        }
        return service;
    }
}
