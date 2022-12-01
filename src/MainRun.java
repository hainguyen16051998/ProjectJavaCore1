import account.entity.User;
import account.handle.HandleAccount;
import account.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        User user1 = new User("Hải", "Hải Dương", "hai123@gmail.com","123");
        User user2 = new User("Tuấn Anh", "Hà Nam", "ta456@gmail.com", "123");
        User user3 = new User("Linh", "Hà Nội", "linh789@gmail.com", "123");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.println(users);
        Menu menu = new Menu();
        HandleAccount handleAccount = new HandleAccount(menu);
        menu.setHandleAccount(handleAccount);
        while (true) {
            menu.mainMenu(scanner, users);
        }
    }
}
