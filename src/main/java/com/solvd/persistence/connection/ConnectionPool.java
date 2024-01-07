package com.solvd.persistence.connection;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {


    private BlockingQueue<Connection> connectionPool;
    private static ConnectionPool instance;

    public ConnectionPool(int connectionPoolSize) throws SQLException, InterruptedException {

        try {
            for (int i = 0; i < connectionPoolSize; i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "admin");
                connectionPool.put(connection);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static ConnectionPool getInstance(int size) throws SQLException, InterruptedException {
        if (instance == null) {
            try {
                instance = new ConnectionPool(size);
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    public Connection getConnection() throws InterruptedException {
        return connectionPool.take();
    }
    public  void releaseConnection(Connection connection){
        connectionPool.offer(connection);
    }

}


