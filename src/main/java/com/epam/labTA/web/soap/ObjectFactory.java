
package com.epam.labTA.web.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPercentage_QNAME = new QName("http://soap.service.labTA.com/", "getPercentage");
    private final static QName _GetDivideResponse_QNAME = new QName("http://soap.service.labTA.com/", "getDivideResponse");
    private final static QName _GetCalculate_QNAME = new QName("http://soap.service.labTA.com/", "getCalculate");
    private final static QName _GetDivide_QNAME = new QName("http://soap.service.labTA.com/", "getDivide");
    private final static QName _GetAddResponse_QNAME = new QName("http://soap.service.labTA.com/", "getAddResponse");
    private final static QName _CalculatorFault_QNAME = new QName("http://soap.service.labTA.com/", "CalculatorFault");
    private final static QName _GetMultiply_QNAME = new QName("http://soap.service.labTA.com/", "getMultiply");
    private final static QName _GetCalculateResponse_QNAME = new QName("http://soap.service.labTA.com/", "getCalculateResponse");
    private final static QName _GetPercentageResponse_QNAME = new QName("http://soap.service.labTA.com/", "getPercentageResponse");
    private final static QName _GetMultiplyResponse_QNAME = new QName("http://soap.service.labTA.com/", "getMultiplyResponse");
    private final static QName _GetSubtract_QNAME = new QName("http://soap.service.labTA.com/", "getSubtract");
    private final static QName _GetSubtractResponse_QNAME = new QName("http://soap.service.labTA.com/", "getSubtractResponse");
    private final static QName _GetAdd_QNAME = new QName("http://soap.service.labTA.com/", "getAdd");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSubtractResponse }
     * 
     */
    public GetSubtractResponse createGetSubtractResponse() {
        return new GetSubtractResponse();
    }

    /**
     * Create an instance of {@link GetAdd }
     * 
     */
    public GetAdd createGetAdd() {
        return new GetAdd();
    }

    /**
     * Create an instance of {@link GetCalculateResponse }
     * 
     */
    public GetCalculateResponse createGetCalculateResponse() {
        return new GetCalculateResponse();
    }

    /**
     * Create an instance of {@link GetPercentageResponse }
     * 
     */
    public GetPercentageResponse createGetPercentageResponse() {
        return new GetPercentageResponse();
    }

    /**
     * Create an instance of {@link GetMultiplyResponse }
     * 
     */
    public GetMultiplyResponse createGetMultiplyResponse() {
        return new GetMultiplyResponse();
    }

    /**
     * Create an instance of {@link GetSubtract }
     * 
     */
    public GetSubtract createGetSubtract() {
        return new GetSubtract();
    }

    /**
     * Create an instance of {@link GetMultiply }
     * 
     */
    public GetMultiply createGetMultiply() {
        return new GetMultiply();
    }

    /**
     * Create an instance of {@link FaultInfo }
     * 
     */
    public FaultInfo createFaultInfo() {
        return new FaultInfo();
    }

    /**
     * Create an instance of {@link GetDivide }
     * 
     */
    public GetDivide createGetDivide() {
        return new GetDivide();
    }

    /**
     * Create an instance of {@link GetAddResponse }
     * 
     */
    public GetAddResponse createGetAddResponse() {
        return new GetAddResponse();
    }

    /**
     * Create an instance of {@link GetDivideResponse }
     * 
     */
    public GetDivideResponse createGetDivideResponse() {
        return new GetDivideResponse();
    }

    /**
     * Create an instance of {@link GetCalculate }
     * 
     */
    public GetCalculate createGetCalculate() {
        return new GetCalculate();
    }

    /**
     * Create an instance of {@link GetPercentage }
     * 
     */
    public GetPercentage createGetPercentage() {
        return new GetPercentage();
    }

    /**
     * Create an instance of {@link Calculator }
     * 
     */
    public Calculator createCalculator() {
        return new Calculator();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPercentage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getPercentage")
    public JAXBElement<GetPercentage> createGetPercentage(GetPercentage value) {
        return new JAXBElement<GetPercentage>(_GetPercentage_QNAME, GetPercentage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDivideResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getDivideResponse")
    public JAXBElement<GetDivideResponse> createGetDivideResponse(GetDivideResponse value) {
        return new JAXBElement<GetDivideResponse>(_GetDivideResponse_QNAME, GetDivideResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalculate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getCalculate")
    public JAXBElement<GetCalculate> createGetCalculate(GetCalculate value) {
        return new JAXBElement<GetCalculate>(_GetCalculate_QNAME, GetCalculate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDivide }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getDivide")
    public JAXBElement<GetDivide> createGetDivide(GetDivide value) {
        return new JAXBElement<GetDivide>(_GetDivide_QNAME, GetDivide.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getAddResponse")
    public JAXBElement<GetAddResponse> createGetAddResponse(GetAddResponse value) {
        return new JAXBElement<GetAddResponse>(_GetAddResponse_QNAME, GetAddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "CalculatorFault")
    public JAXBElement<FaultInfo> createCalculatorFault(FaultInfo value) {
        return new JAXBElement<FaultInfo>(_CalculatorFault_QNAME, FaultInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultiply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getMultiply")
    public JAXBElement<GetMultiply> createGetMultiply(GetMultiply value) {
        return new JAXBElement<GetMultiply>(_GetMultiply_QNAME, GetMultiply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalculateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getCalculateResponse")
    public JAXBElement<GetCalculateResponse> createGetCalculateResponse(GetCalculateResponse value) {
        return new JAXBElement<GetCalculateResponse>(_GetCalculateResponse_QNAME, GetCalculateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPercentageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getPercentageResponse")
    public JAXBElement<GetPercentageResponse> createGetPercentageResponse(GetPercentageResponse value) {
        return new JAXBElement<GetPercentageResponse>(_GetPercentageResponse_QNAME, GetPercentageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultiplyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getMultiplyResponse")
    public JAXBElement<GetMultiplyResponse> createGetMultiplyResponse(GetMultiplyResponse value) {
        return new JAXBElement<GetMultiplyResponse>(_GetMultiplyResponse_QNAME, GetMultiplyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubtract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getSubtract")
    public JAXBElement<GetSubtract> createGetSubtract(GetSubtract value) {
        return new JAXBElement<GetSubtract>(_GetSubtract_QNAME, GetSubtract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubtractResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getSubtractResponse")
    public JAXBElement<GetSubtractResponse> createGetSubtractResponse(GetSubtractResponse value) {
        return new JAXBElement<GetSubtractResponse>(_GetSubtractResponse_QNAME, GetSubtractResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.labTA.com/", name = "getAdd")
    public JAXBElement<GetAdd> createGetAdd(GetAdd value) {
        return new JAXBElement<GetAdd>(_GetAdd_QNAME, GetAdd.class, null, value);
    }

}
