package com.epam.labTA.web;

import com.epam.labTA.web.soap.Calculator;
import com.epam.labTA.web.soap.SoapException;
import io.qameta.allure.Step;


public interface CalculatorService {


    double getCalculate(Calculator calculator) throws SoapException;


    @Step("Step for add num1: {} and num2: {} ...")
    double getAdd(double x , double y ) throws SoapException;

    double getSubtract(double x , double y ) throws  SoapException;

    double getMultiply(double x , double y ) throws SoapException;


    double getDivide(double x , double y ) throws SoapException;

    double getPercentage(double x , double y ) throws  SoapException;
}
