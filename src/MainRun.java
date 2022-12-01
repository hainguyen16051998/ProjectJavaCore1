import account.entity.User;
import account.handle.HandleAccount;
import account.view.Menu;
import shop.entity.Customer;
import shop.entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) throws Exception {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        User user1 = new User("hai", "Hải Dương", "hai123@gmail.com", "123");
        user1.setRole("admin");
        User user2 = new Customer("tuan", "Hà Nam", "ta456@gmail.com", "123");
        User user3 = new User("linh", "Hà Nội", "linh789@gmail.com", "123");
        users.add(user1);
        user2.setRole("customer");
        users.add(user2);
        users.add(user3);
        System.out.println(users);
        Menu menu = new Menu();
        HandleAccount handleAccount = new HandleAccount(menu,shop);
        menu.setHandleAccount(handleAccount);
        menu.setShop(shop);
        while (true) {
            menu.mainMenu(scanner, users);
            System.out.println(users);
        }
    }
}
