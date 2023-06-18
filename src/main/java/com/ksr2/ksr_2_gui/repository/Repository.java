package com.ksr2.ksr_2_gui.repository;
import java.sql.*;

public class Repository {

    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASS;
    public Repository(final String DB_URL, final String DB_USER, final String DB_PASS){
        this.DB_URL = DB_URL;
        this.DB_USER = DB_USER;
        this.DB_PASS = DB_PASS;
    }

    public void retriveData(String query) throws SQLException {
        try (Connection conn = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASS)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getInt("measurment") + " " + rs.getInt("views"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
