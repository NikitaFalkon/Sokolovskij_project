package Working;
import Users.*;
import ListsofBooks.*;
import java.util.Scanner;

public class ReaderAction {
    LybraryProm lyb = new LybraryProm();
    public void TakeABook(Readerr reader, Lybrary lybrary, String login, Users users)
    {
        System.out.println("Choose a book");
        lybrary.WriteBooks();
        Scanner scan = new Scanner(System.in);
        String book = scan.nextLine();
        String author = scan.nextLine();
        if (lybrary.FindBook(book, author))
        {
            if (lyb.Permission(users))
            {
                lybrary.GiveBook(book, author);
                reader.TakeBook(book, author, login);
            }
            else
            {
                System.out.println("Nelzia!!!!");
            }
        }
        else
        {
            System.out.println("This book doesn't exist");
        }
    }
    public void TakeAPerm(Readerr reader, String login, Users users)
    {
        if(reader.ReturnPermission(login)<=0)
        {
            if (lyb.Permission(users))
            {
                reader.TakePermission(login);
            }
            else
            {
                System.out.println("Nelzia!!!!");
            }
        }
        else
        {
            System.out.println("You are alredy have a permission");
        }
    }
}
