package com.solvd.persistence.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {


    private BlockingQueue<Connection> connectionPool;
    private static ConnectionPool instance;

    private String url;
    private String username;
    private String password;

    public ConnectionPool(int connectionPoolSize) throws SQLException, InterruptedException {
        this.connectionPool = new ArrayBlockingQueue<>(connectionPoolSize);

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties") {
            Properties properties = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            properties.load(input);

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");

            for (int i = 0; i < connectionPoolSize; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                connectionPool.put(connection);
            }

        } catch (IOException | SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        public synchronized static ConnectionPool getInstance (int size) throws SQLException, InterruptedException {
            if (instance == null) {
                try {
                    instance = new ConnectionPool(size);
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return instance;
        }
        public Connection getConnection () throws InterruptedException {
            return connectionPool.take();
        }
        public void releaseConnection (Connection connection){
            connectionPool.offer(connection);
        }

    }
}

