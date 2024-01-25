package com.solvd.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateAdapter extends XmlAdapter< String, Date> {


    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd";

    @Override
    public String marshal(Date value) {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(value);
    }

    @Override
    public Date unmarshal(String value) throws ParseException {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(value);
    }

}