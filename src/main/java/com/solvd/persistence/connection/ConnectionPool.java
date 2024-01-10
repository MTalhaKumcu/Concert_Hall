package com.solvd.persistence.connection;

import java.lang.reflect.Proxy;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Class.forName;

public class ConnectionPool {


    private static ConnectionPool connectionPool;
    private static final String URL_KEY = "url";
    private static final String USER_KEY = "user";
    private static final String PASSWORD_KEY = "password";
    private static final String DRIVER_KEY = "driver";
    private static final String POOL_SIZE_KEY = "size";
    private static BlockingQueue<Connection> pool;
    private static List<Connection> sourceConnections;

    public ConnectionPool() {
    }

    static {
        loadDriver();
        initConnectionPool();
    }

    private static void initConnectionPool() {

        int size = Integer.parseInt(DBpropertiesUtil.get(POOL_SIZE_KEY));
        pool = new ArrayBlockingQueue<>(size);
        sourceConnections = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Connection connection = open();
            Connection proxyConnections = (Connection) Proxy.newProxyInstance(ConnectionPool.class.getClassLoader(),
                    new Class[]{Connection.class},
                    (proxy, method, args) -> method.getName().equals("close") ? pool.add((Connection) proxy)
                            : method.invoke(connection, args));
            pool.add(proxyConnections);
            sourceConnections.add(connection);
        }
    }

    private static Connection open() {
        try {
            return DriverManager.getConnection(DBpropertiesUtil.get(URL_KEY),
                    DBpropertiesUtil.get(USER_KEY),
                    DBpropertiesUtil.get(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver() {

        try {

            Class.forName(DBpropertiesUtil.get(DRIVER_KEY));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection get() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void releaseConnection(Connection connection) {
        pool.offer(connection);
    }

    public static void closeConnectionPool() {
        try {
            for (Connection sourceConnection : sourceConnections) {
                sourceConnection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

