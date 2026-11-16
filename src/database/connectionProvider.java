package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class connectionProvider {

    private static Connection connection;

    public static void createConnection() throws Exception {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Default connection values
            String dbUrl = "jdbc:mysql://localhost:3306/bms";
            String dbUser = "root";
            String dbPassword = "";

            // 1. Try loading from db.properties if available
            File configFile = new File("db.properties");
            if (configFile.exists()) {
                Properties props = new Properties();
                try (InputStream in = new FileInputStream(configFile)) {
                    props.load(in);
                    if (props.containsKey("db.url")) {
                        dbUrl = props.getProperty("db.url");
                    }
                    if (props.containsKey("db.user")) {
                        dbUser = props.getProperty("db.user");
                    }
                    if (props.containsKey("db.password")) {
                        dbPassword = props.getProperty("db.password");
                    }
                }
            }

            // 2. Allow environment variables to override
            String envUrl = System.getenv("DB_URL");
            String envUser = System.getenv("DB_USER");
            String envPassword = System.getenv("DB_PASSWORD");

            if (envUrl != null && !envUrl.trim().isEmpty()) {
                dbUrl = envUrl.trim();
            }
            if (envUser != null && !envUser.trim().isEmpty()) {
                dbUser = envUser.trim();
            }
            if (envPassword != null) {
                dbPassword = envPassword;
            }

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        }
    }

    public static Connection getCon() throws Exception {
        createConnection();
        return connection;
    }

    public static ResultSet executeSearch(String query) throws Exception {
        createConnection();
        return connection.createStatement().executeQuery(query);
    }

    public static Integer executeIUD(String query) throws Exception {
        createConnection();
        return connection.createStatement().executeUpdate(query);
    }
}
