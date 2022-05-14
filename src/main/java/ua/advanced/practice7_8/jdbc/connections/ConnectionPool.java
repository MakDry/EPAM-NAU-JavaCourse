package ua.advanced.practice7_8.jdbc.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

class ConnectionPool {
    private final int initialConnections = 5;
    Deque<Connection> connectionsAvailable = new ArrayDeque<>();
    Deque<Connection> connectionsUsed = new ArrayDeque<>();

    private String url;
    private String user;
    private String password;
    private String driver;

    public ConnectionPool(String url, String user, String password, String driver) throws SQLException {
        try {
            this.url = url;
            this.user = user;
            this.password = password;
            this.driver = driver;
            Class.forName(driver);
            for (int i = 0; i < initialConnections; i++) {
                connectionsAvailable.add(createConnection());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load a driver " + e.getMessage());
        }
    }

    public synchronized Connection getConnection() {
        Connection newConnection = null;
        try {
            if (!connectionsAvailable.isEmpty()) {
                newConnection = connectionsAvailable.remove();
                connectionsUsed.add(newConnection);
            } else {
                throw new EmptyStackException();
            }
        } catch (EmptyStackException e) {
            System.err.println("There no more available connects");
        }
        return newConnection;
    }

    public synchronized void releaseConnection() {
        Connection releasedConnection = null;
        try {
            if (!connectionsUsed.isEmpty()) {
                releasedConnection = connectionsUsed.remove();
                connectionsAvailable.add(releasedConnection);
            } else {
                throw new EmptyStackException();
            }
        } catch (EmptyStackException e) {
            System.err.println("There no using connects");
        }
    }

    public synchronized void closeAll() throws SQLException {
        Connection connection;
        for (int i = 0; i < initialConnections; i++) {
            connection = connectionsAvailable.remove();
            connection.close();
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
