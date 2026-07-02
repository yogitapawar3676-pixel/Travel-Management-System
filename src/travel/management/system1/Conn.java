package travel.management.system1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class Conn {

    Connection c;

    Statement s;



    public Conn() {

        try {

            // Load the MySQL JDBC driver

            Class.forName("com.mysql.cj.jdbc.Driver");



            // Replace 'your_database_url', 'your_username', and 'your_password' with your MySQL database details

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsm", "root", "Yogita@1109");



            // Create a Statement object

            s = c.createStatement();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    public Connection getConnection() {

        return c;

    }

}