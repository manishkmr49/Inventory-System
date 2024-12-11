package main.java.others;

import main.java.controllers.PromptDialogController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/inventory?autoReconnect=yes&useSSL=no";

    public static Connection getConnection() {
        Connection con;
        try {
            // Update the password here to "12345"
            con = DriverManager.getConnection(URL, "root", "12345");
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getErrorCode() == 0) { // Error Code 0: database server offline
                new PromptDialogController("Error!", "Database server is offline!");
            }
            return null;
        }
        return con;
    }
}
