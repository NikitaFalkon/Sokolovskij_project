package Menu;

import ListsofBooks.Lybrary;
import ListsofBooks.Users;
import Users.*;
import Working.*;
import java.util.Scanner;
public class ReaderrMenu {
    Scanner scan = new Scanner(System.in);
    Lybrary lybrary;
    ReaderAction Readeract;
    public ReaderrMenu(Lybrary lyb, ReaderAction Read, Users use)
    {
        this.lybrary = lyb;
        this.Readeract = Read;
    }
    public void WriteMenu(Readerr reader, String login, Users users)
    {
        int i = 0;
        while(i<5)
        {
            System.out.println("1.List of books and permission\n2Take a book\n3.Take a permission\n4.List of books in library\n5+.Exit");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            try {
                switch (i) {
                    case 1:
                        reader.WriteBooks(login);
                        break;
                    case 2:
                        Readeract.TakeABook(reader, lybrary, login, users);
                        break;
                    case 3:
                        Readeract.TakeAPerm(reader, login, users);
                        break;
                    case 4:
                        lybrary.WriteBooks();
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("You wrote something wrong");
            }
        }


    }
}
