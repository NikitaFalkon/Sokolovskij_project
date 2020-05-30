package Menu;
import ListsofBooks.*;
import Working.ReaderAction;
import Users.Librarian;
import java.io.*;
import java.util.Scanner;


public class LibrarianMenu {
    Lybrary lybrary;
    Users users;
    String login;
    String pass;
    int perm;
    int type;
    public LibrarianMenu(Lybrary lyb, Users use)
    {
        this.lybrary = lyb;
        this.users = use;
    }
    public void WriteMenu(Librarian lybrarian)
    {

        int i = 0;
        while(i<4)
        {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("1.List of books in Library\n2.List of users\n3.Add new user\n4+.Exit");
                i = scan.nextInt();
                switch (i) {
                    case 1:
                        System.out.println(i);
                        lybrary.WriteBooks();
                        break;
                    case 2:
                        users.WriteUsers();
                        break;
                    case 3:
                        Scanner sca = new Scanner(System.in);
                        System.out.println("Write login, password, permission(0 - no, 1+ - yes) and type(0 - lybrarian, 1+ - reader)");
                        login = sca.nextLine();
                        pass = sca.nextLine();
                        perm = sca.nextInt();
                        type = sca.nextInt();
                        users.AddUser(login, pass, perm, type);
                        break;
                }
            }
            catch (Exception ex)
            {
              System.out.println("You wrote something wrong");
              System.out.println();
            }
        }
    }

}
