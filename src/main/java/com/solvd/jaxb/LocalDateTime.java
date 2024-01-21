package com.solvd.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;


public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {


    public LocalDateTime unmarshal(String value) throws Exception {
        return LocalDateTime.parse(value);
    }

    public String marshal(java.time.LocalDateTime localDateTime) throws Exception {
        return localDateTime.toString();
    }

}

