package ListsofBooks;
import Users.*;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    String url = "jdbc:mysql://localhost:3307/newbase?serverTimezone=Europe/Moscow&useSSL=false";
    String username = "root";
    String password = "root";
    private String types;
    Readerr rea = new Readerr();
    Librarian lybrarian = new Librarian();
    Scanner scan = new Scanner(System.in);
    public Users()
    {
    }
    public  void WriteUsers()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next())
                {
                    String name = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    int perm = resultSet.getInt(3);
                    int type = resultSet.getInt(4);
                    System.out.printf("%s %s %d %d \n", name, password, perm, type);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }
    public  void AddUser(String login,String  pass,int perm,int  type)
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            if(type>0)
            {
                String sqlCommand = "CREATE TABLE " + login + " (BOOKS VARCHAR(20), AUTHORS VARCHAR(20), Quantity INT)";
                try (Connection conn = DriverManager.getConnection(url, username, password)) {

                    Statement statement = conn.createStatement();
                    int rows = statement.executeUpdate("INSERT users(login, password, perm, type) VALUES ('"+login+"', '"+pass+"', "+perm+", "+type+")");
                    statement.executeUpdate(sqlCommand);
                    System.out.println("Reader has been created!");
                }
            }
            else
            {
                try (Connection conn = DriverManager.getConnection(url, username, password)) {

                    Statement statement = conn.createStatement();
                    int rows = statement.executeUpdate("INSERT users(login, password, perm, type) VALUES ('"+login+"', '"+pass+"', "+perm+", "+type+")");
                    System.out.println("Lybrarian has been created!");
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }
    public boolean FindUser(String login, String pass)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next())
                {
                    String  log= resultSet.getString(1);
                    String  pa= resultSet.getString(2);
                    int y = resultSet.getInt(3);
                    int  ty= resultSet.getInt(4);
                    if(login.equals(log)&&pass.equals(pa))
                    {
                        if(ty!=0) this.types = "Readerr";
                        else this.types = "Lybrarian";
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return false;
    }
    public boolean FindLybrarian(String login, String pass)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next())
                {
                    String  log= resultSet.getString(1);
                    String  pa= resultSet.getString(2);
                    int  ty= resultSet.getInt(4);
                    if(login.equals(log)&&pass.equals(pa))
                    {
                        if(ty==0)
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return false;
    }
    public Readerr GetReaderr(String login)
    {
            rea.GetLogin(login);
            return rea;
    }
    public Librarian GetLybrarian(String login)
    {
        lybrarian.GetLogin(login);
        return lybrarian;
    }
    public String ReturnType()
    {
        return types;
    }

}
