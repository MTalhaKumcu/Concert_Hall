package com.solvd.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {


    //there is a mistake , i made all Date from date ,
    // i dont know how to fix the situation shortly (file is JdbcDaoImpl)
    public LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDateTime unmarshal(String value) throws Exception {
        return LocalDateTime.parse(value);
    }

    public String marshal(java.time.LocalDateTime localDateTime) throws Exception {
        return localDateTime.toString();
    }

}

