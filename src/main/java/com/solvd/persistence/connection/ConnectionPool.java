package com.solvd.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionPool {

    // private static final String sql = "SELECT * FROM  Concert_Hall.artists WHERE ArtistID=2;";
    private static final  String url = "jdbc:mysql://localhost:3306/concert_hall";
    private static final  String username ="root";
    private static final  String password ="admin";


    Connection connection = DriverManager.getConnection(url,username,password);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
    String artistID = resultSet.getString(1);
        System.out.println(artistID);
}
