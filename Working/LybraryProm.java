package Working;

import java.util.Scanner;
import ListsofBooks.Users;
public class LybraryProm {

    public boolean Permission(Users use)
    {
        Scanner scani = new Scanner(System.in);
        System.out.println("Do you give permission for this action?\n1.yes\nelse.no");

        int perm = scani.nextInt();
        if(perm==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
