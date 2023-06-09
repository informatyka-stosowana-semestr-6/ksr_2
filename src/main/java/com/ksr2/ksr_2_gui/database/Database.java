package com.ksr2.ksr_2_gui.database;
import java.sql.*;

public class Database {
    String url = "jdbc:sqlite" + System.getProperty("user.dir") + "data.db";
    Connection connection;

    public Database() throws SQLException {
        this.connection = DriverManager.getConnection(url);

    }
    public ResultSet getFromQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
}
