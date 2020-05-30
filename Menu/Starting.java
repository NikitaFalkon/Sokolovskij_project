package Menu;

import ListsofBooks.Lybrary;
import ListsofBooks.Users;
import Working.ReaderAction;
import Users.*;

import java.util.Scanner;

public class Starting {
    Users users;
    Lybrary lyb;
    ReaderAction Read;
    LibrarianMenu lib;
    ReaderrMenu red;
    Scanner scan = new Scanner(System.in);
    String login;
    String pass;

    public void Start(Users user, Lybrary lyby, ReaderAction Rea)
    {
        this.users = user;
        this.lyb = lyby;
        this.Read = Rea;
        lib = new LibrarianMenu(lyb, users);
        red = new ReaderrMenu(lyb, Read, users);
        String cont ="yes";
        while(cont.equals("yes"))
        {
            System.out.println("Write your login and password");
            String login = scan.nextLine();
            String password = scan.nextLine();
            if(users.FindUser(login, password))
            {
                if(users.ReturnType().equals("Readerr"))
                {
                    System.out.println("Readerr");
                    UserWork(users.GetReaderr(login), login, user);
                }
                if(users.ReturnType().equals("Lybrarian"))
                {
                    System.out.println("Lybrarian");
                    UserWork(users.GetLybrarian(login));
                }
            }
            System.out.println("Do you want to continue\nWrite yes");
            cont = scan.nextLine();
        }
    }
    public void UserWork(Readerr reader, String log, Users users)
    {
        red.WriteMenu(reader, log, users);
    }
    public void UserWork(Librarian lybr)
    {
        lib.WriteMenu(lybr);
    }
}
