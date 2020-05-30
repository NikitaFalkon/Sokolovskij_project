import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import ListsofBooks.*;
import Menu.Starting;
import Working.ReaderAction;

public class Main{

    public static void main(String[] args)
    {
        Lybrary lybrary = new Lybrary();
        Users users = new Users();
        ReaderAction Rea = new ReaderAction();
        Starting starting = new Starting();
        starting.Start(users, lybrary, Rea);

    }
}
