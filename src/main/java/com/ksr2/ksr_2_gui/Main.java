package com.ksr2.ksr_2_gui;

import com.ksr2.ksr_2_gui.repository.Repository;

import java.sql.SQLException;

public class Main {
public static void main(String[] args) throws SQLException {
//    HelloApplication.main(args);
    Repository rep = new Repository("jdbc:postgresql://localhost:5432/test", "postgres", "molcza_0712");
    rep.retriveData("select * from views");
}
}
