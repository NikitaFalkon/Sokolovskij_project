package ListsofBooks;

import Working.ReaderAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class Lybrary {
    String url = "jdbc:mysql://localhost:3307/newbase?serverTimezone=Europe/Moscow&useSSL=false";
    String username = "root";
    String password = "root";


    public  void WriteBooks()
    {
            try
            {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
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
    public boolean FindBook(String book, String author)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");
                while(resultSet.next())
                {
                    String name = resultSet.getString(1);
                    String aut = resultSet.getString(2);
                    if(name==book&&aut==author);
                    return true;
                }

            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return false;
    }
    public void GiveBook(String book, String author)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Books Where book = '"+book+"'");
                while(resultSet.next())
                {
                        int colvo = resultSet.getInt(3);
                        if(colvo>1)
                        {
                            int rows = statement.executeUpdate("UPDATE Books SET Quantity = Quantity - 1 Where book ='"+book+"' and author ='"+author+"'");
                            break;
                        }
                        else
                        {
                            int rows = statement.executeUpdate("DELETE FROM Books WHERE book ='"+book+"'and author ='"+author+"'");
                            break;
                        }
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
}
