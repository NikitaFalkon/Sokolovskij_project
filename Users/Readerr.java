package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Readerr extends User {
    String url;
    public String username;
    String password;
    private boolean Permission = false;
    public Readerr(/*String log*/)
    {
        url = "jdbc:mysql://localhost:3307/newbase?serverTimezone=Europe/Moscow&useSSL=false";
        username = "root";
        password = "root";
        //this.login = log;
    }
    public void TakeBook(String book, String author, String login)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT " + login +" (BOOKS, AUTHORS, Quantity) VALUES ('"+book+"', '"+author+"', 1)");

            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public void WriteBooks(String login)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + login + "");
                while(resultSet.next())
                {
                    String name = resultSet.getString(1);
                    String author = resultSet.getString(2);
                    int quantity = resultSet.getInt(3);
                    System.out.printf("%s %s %d \n", name, author, quantity);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public void TakePermission(String log)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users Where login = '"+log+"'");
                while(resultSet.next())
                {
                    int colvo = resultSet.getInt(3);
                    int rows = statement.executeUpdate("UPDATE users SET perm = 1 Where login = '"+log+"'");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public int ReturnPermission(String log)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE login = '"+log+"'");
                while(resultSet.next())
                {
                    int quantity = resultSet.getInt(3);
                    return quantity;
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return 0;
    }


}
