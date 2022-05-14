package ua.advanced.practice7_8.jdbc.connections;

import ua.advanced.practice7_8.jdbc.dao.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionSetter {
    private final String resourceFile = "/src/main/java/ua/advanced/practice7/connections/database.properties";
    private ResourceBundle resource;
    private static ConnectionPool connections;

    public ConnectionSetter() {
        try {
            resource = ResourceBundle.getBundle(resourceFile);
            String url = resource.getString("db.url");
            String user = resource.getString("db.user");
            String pass = resource.getString("db.password");
            String driver = resource.getString("db.driver");
            connections = new ConnectionPool(url, user, pass, driver);
        } catch (SQLException e) {
            throw new DaoException("Incorrect connection with database");
        }
    }
    public Connection take() {
        return connections.getConnection();
    }

    public void release() {
        connections.releaseConnection();
    }

    public static void closeConnections() throws SQLException {
        connections.closeAll();
    }
}
