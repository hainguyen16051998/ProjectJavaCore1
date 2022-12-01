import account.entity.User;
import account.handle.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("Hải", "Hải Dương", "hai123@gmail.com","34","a","123","Admin" );
        User user2 = new User("Tuấn Anh", "Hà Nam", "ta456@gmail.com","90","b","456","Staff" );
        User user3 = new User("Linh", "Hà Nội", "linh789@gmail.com","30","c","789","Customer" );
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.println(users);
        Menu menu = new Menu();
        menu.displayMenu(scanner, users);
    }
}
