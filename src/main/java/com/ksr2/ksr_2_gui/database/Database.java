package com.ksr2.ksr_2_gui.database;

import java.net.URL;
import java.sql.*;
import java.util.Enumeration;
import java.util.Objects;

public class Database {
    private final Connection connection;

    public Database() throws SQLException {
        String dbPath = Objects.requireNonNull(Database.class.getResource("houses_data.db")).getPath();
        dbPath = dbPath.replaceFirst("^/", "");
        String url = "jdbc:sqlite:" + dbPath;
        this.connection = DriverManager.getConnection(url);

    }

    public ResultSet getFromQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
}
