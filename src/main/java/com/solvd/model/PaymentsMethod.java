package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "PaymentsMethod")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentsMethod {

    @XmlElement
    @JsonProperty("ticketTypeID")
    private int paymentMethodID;

    @XmlElement
    @JsonProperty("ticketTypeName")
    private String paymentMethodName;

    @XmlElement
    @JsonProperty("description")
    private String description;

    public PaymentsMethod(int paymentMethodID, String paymentMethodName, String description) {

        this.paymentMethodID = paymentMethodID;
        this.paymentMethodName = paymentMethodName;
        this.description = description;

    }

    public PaymentsMethod() {

    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public int setPaymentMethodID(int paymentMethodID) {
        return paymentMethodID = paymentMethodID;
    }
    // Warning

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void paymentMethodName(String paymentMethodName) {
        paymentMethodName = paymentMethodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
