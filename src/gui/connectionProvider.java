package gui;

import java.sql.Connection;
import java.sql.ResultSet;

public class connectionProvider {

    public static void createConnection() throws Exception {
        database.connectionProvider.createConnection();
    }

    public static Connection getCon() throws Exception {
        return database.connectionProvider.getCon();
    }

    public static ResultSet executeSearch(String query) throws Exception {
        return database.connectionProvider.executeSearch(query);
    }

    public static Integer executeIUD(String query) throws Exception {
        return database.connectionProvider.executeIUD(query);
    }
}
