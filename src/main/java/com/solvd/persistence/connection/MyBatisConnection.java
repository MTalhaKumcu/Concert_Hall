package com.solvd.persistence.connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConnection {

    private static final String MYBATIS_CONFIG_FILE = "myBatis.xml";
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try (InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("SqlSessionFactory sqlSessionFactory", e);

        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return  sqlSessionFactory;
    }
}
