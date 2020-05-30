package Users;
import java.util.Scanner;

abstract class User {
    public String login;
    public String password;
    /*public String Log()
    {
        return login;
    }*/
    public String Pass()
    {
        return password;
    }
    public User()
    {
       // Scanner scan = new Scanner(System.in);
        //login = scan.nextLine();
        //password = scan.nextLine();
    }
    public String ReturnLogin()
    {
       return login;
    }
    public void GetLogin(String log)
    {
        this.login = log;
    }
}
