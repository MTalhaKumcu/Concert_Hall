package com.solvd.persistence.connection;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {


    private BlockingQueue<Connection> connectionPool;
    private static ConnectionPool instance;

    public ConnectionPool(int connectionPoolSize) throws SQLException, InterruptedException {

        this.connectionPool = new ArrayBlockingQueue<>(connectionPoolSize);

        for (int i = 0; i < connectionPoolSize; i++) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "admin");
            connectionPool.put(connection);
        }
    }

    public synchronized static ConnectionPool getInstance(int size) throws SQLException, InterruptedException {
        if (instance == null) {
            instance = new ConnectionPool(size);
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


